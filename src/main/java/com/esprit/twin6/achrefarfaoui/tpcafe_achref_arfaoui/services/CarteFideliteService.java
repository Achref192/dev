package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.CarteFidelite;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.CarteFideliteMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.CarteFideliteRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CarteFideliteService implements ICarteFideliteService {

    private final CarteFideliteRepository carteFideliteRepository;
    private final CarteFideliteMapper carteFideliteMapper;

    @Override
    public CarteFideliteResponse addCarteFidelite(CarteFideliteRequest carteFidelite) {
        CarteFidelite cart = carteFideliteMapper.toEntity(carteFidelite);
        CarteFidelite saved = carteFideliteRepository.save(cart);
        return carteFideliteMapper.toDto(saved);
    }

    @Override
    public List<CarteFideliteResponse> saveCarteFidelites(List<CarteFideliteRequest> carteFidelites) {
        List<CarteFidelite> carts = carteFideliteMapper.toentity2(carteFidelites);
        List<CarteFidelite> saved = carteFideliteRepository.saveAll(carts);
        return carteFideliteMapper.todto2(saved);
    }

    @Override
    public CarteFideliteResponse selectCarteFideliteById(long id) {
        CarteFidelite c = carteFideliteRepository.findById(id).orElseThrow();
        return carteFideliteMapper.toDto(c);
    }

    @Override
    public List<CarteFideliteResponse> selectAllCarteFidelites() {
        return carteFideliteMapper.todto2(carteFideliteRepository.findAll());
    }

    @Override
    public void deleteCarteFidelite(CarteFideliteRequest carteFidelite) {
        CarteFidelite c = carteFideliteMapper.toEntity(carteFidelite);
        carteFideliteRepository.delete(c);
    }

    @Override
    public void deleteAllCarteFidelites() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteFideliteById(long id) {
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public long countingCarteFidelites() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifyCarteFideliteById(long id) {
        return carteFideliteRepository.existsById(id);
    }

    // ======================================================
    // 🎉 SCHEDULER : +10% points chaque jour à minuit
    // ======================================================

    @Scheduled(cron = "0 0 0 * * *") // tous les jours à minuit
    @Override
    public void incrementerPointsAnniversaire() {

        LocalDate today = LocalDate.now();
        log.info("🎉 Vérification des anniversaires du {}", today);

        // 👉 On récupère SEULEMENT les cartes concernées
        List<CarteFidelite> cartes = carteFideliteRepository.findCartesAnniversaireAujourdhui();

        if (cartes.isEmpty()) {
            log.info("🎂 Aucun client en anniversaire aujourd'hui.");
            return;
        }

        for (CarteFidelite carte : cartes) {

            int anciensPoints = carte.getPointsAccumules();
            int nouveauxPoints = (int) (anciensPoints * 1.10); // +10%

            carte.setPointsAccumules(nouveauxPoints);

            log.info("🎂 {} {} | points : {} → {}",
                    carte.getClient().getNom(),
                    carte.getClient().getPrenom(),
                    anciensPoints,
                    nouveauxPoints
            );

            // Sauvegarde de cette carte
            carteFideliteRepository.save(carte);
        }

        log.info("✅ Mise à jour terminée pour {} client(s).", cartes.size());
    }

}
