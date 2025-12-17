package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.schedular;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.CarteFidelite;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.CarteFideliteRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.PromotionRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.CarteFideliteService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;



@Component
@AllArgsConstructor
@Slf4j
public class ScheduledMethods {

    private final CarteFideliteService carteFideliteService;
    private final CarteFideliteRepository carteFideliteRepository;
    private final PromotionRepository promotionRepository;

    // ================= EXEMPLES DE SCHEDULER =================

    @Scheduled(fixedRate = 2000)
    public void scheduledMethods() {
        log.info("scheduledMethods (fixedRate) started");
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduledMethods2() {
        log.info("scheduledMethods2 (fixedDelay) started");
    }

    @Scheduled(cron = "15 * * * * *") // à la seconde 15 de chaque minute
    public void scheduledMethods3() {
        log.info("scheduledMethods3 (cron) started");
    }

    // ============= SCHEDULER POINTS FIDÉLITÉ =============

    @Scheduled(cron = "0 0 0 * * *") // tous les jours à minuit
    public void schedulerPointsFidelite() {

        log.info("⏰ Scheduler lancé → vérification des anniversaires...");

        List<CarteFidelite> cartes =
                carteFideliteRepository.findCartesAnniversaireAujourdhui();

        for (CarteFidelite carte : cartes) {
            log.info("🎂 Aujourd'hui c'est l'anniversaire de : {} {}",
                    carte.getClient().getNom(),
                    carte.getClient().getPrenom());
        }

        carteFideliteService.incrementerPointsAnniversaire();

        log.info("✅ Tâche scheduler fidélité exécutée avec succès");
    }

    // ============= SCHEDULER ARTICLES EN PROMOTION / MOIS COURANT =============

    /**
     * Méthode qui se déclenche automatiquement
     * le 1er jour de chaque mois à 00:00
     * et affiche les articles en promotion sur le mois en cours.
     */
    @Transactional
    @Scheduled(cron = "*/10 * * * * *") // pour tester toutes les 10 sec
    public void afficherArticlesEnPromotionPourMoisCourant() {

        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfMonth(1);
        LocalDate lastDay  = today.withDayOfMonth(today.lengthOfMonth());

        log.info("📅 Début du mois → recherche des articles en promotion pour {} {}",
                today.getMonth(), today.getYear());

        List<Promotion> promotions = promotionRepository.findAll();

        for (Promotion promo : promotions) {

            if (promo.getDateDebutPromo() == null || promo.getDateFinPromo() == null) {
                continue;
            }

            LocalDate debut = promo.getDateDebutPromo();
            LocalDate fin   = promo.getDateFinPromo();

            boolean chevaucheMois =
                    !fin.isBefore(firstDay) && !debut.isAfter(lastDay);

            if (!chevaucheMois) {
                continue;
            }

            log.info("🔻 Promotion ID={} | %={} | du {} au {}",
                    promo.getIdPromotion(),
                    promo.getPourcentagePromo(),
                    debut,
                    fin);

            if (promo.getArticles() == null || promo.getArticles().isEmpty()) {
                log.info("   (aucun article lié à cette promotion)");
            } else {
                promo.getArticles().forEach(article -> {
                    // ⚠ adapte les noms de getters si besoin (idArticle / nomArticle…)
                    log.info("   → Article en promo : id={} | nom={}",
                            article.getIdArticle(),
                            article.getNomArticle());
                });
            }
        }
    }

}


