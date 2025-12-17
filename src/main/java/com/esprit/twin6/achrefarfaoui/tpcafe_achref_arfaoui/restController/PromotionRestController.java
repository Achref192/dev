package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.restController;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.IPromotionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("promotion")
@Tag(name = "Promotion", description = "Gestion des Promotions")
@AllArgsConstructor
public class PromotionRestController {

    private IPromotionService promotionService;

    @Operation(summary = "Récupérer toutes les promotions", description = "Retourne la liste complète de toutes les promotions")
    @GetMapping
    public List<PromotionResponse> selectAllPromotion() {
        return promotionService.selectAllPromotion();
    }

    @Operation(summary = "Ajouter une nouvelle promotion", description = "Crée une nouvelle promotion dans le système")
    @PostMapping("/addpromo")
    public PromotionResponse addPromotion(@RequestBody PromotionRequest promotion) {
        return promotionService.addPromotion(promotion);
    }

    @Operation(summary = "Ajouter une liste de promotions", description = "Ajoute plusieurs promotions en une seule opération")
    @PostMapping("/list")
    public List<PromotionResponse> addPromotions(@RequestBody List<PromotionRequest> promotions) {
        return promotionService.savePromotion(promotions);
    }

    @Operation(summary = "Récupérer une promotion par ID avec paramètre", description = "Retourne une promotion spécifique selon son identifiant (via paramètre)")
    @GetMapping("/selectById2")
    public PromotionResponse selectPromotionById2(@RequestParam long id) {
        return promotionService.selectPromotionById(id);
    }

    @Operation(summary = "Récupérer une promotion par ID avec chemin", description = "Retourne une promotion spécifique selon son identifiant (via chemin)")
    @GetMapping("selectByID/{id}")
    public PromotionResponse selectPromotionByID(@PathVariable long id) {
        return promotionService.selectPromotionById(id);
    }

    @Operation(summary = "Supprimer une promotion", description = "Supprime une promotion en la passant dans le corps de la requête")
    @DeleteMapping("/del")
    public void deletePromotion(@RequestBody PromotionRequest promotion) {
        promotionService.deletePromotion(promotion);
    }

    @Operation(summary = "Supprimer une promotion par ID", description = "Supprime une promotion spécifique selon son identifiant")
    @DeleteMapping("delete/{id}")
    public void deletePromotionByID(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }

    @Operation(summary = "Supprimer toutes les promotions", description = "Vide complètement la liste des promotions")
    @DeleteMapping("all")
    public void deleteAllPromotions() {
        promotionService.deleteAllPromotion();
    }

    @Operation(summary = "Compter le nombre de promotions", description = "Retourne le nombre total de promotions dans le système")
    @GetMapping("count")
    public long countPromotion() {
        return promotionService.countingPromotion();
    }

    @Operation(summary = "Vérifier l'existence d'une promotion", description = "Retourne true si une promotion existe avec l'ID spécifié, false sinon")
    @GetMapping("exist/{id}")
    public boolean exist(@PathVariable long id) {
        return promotionService.verifyPromotionById(id);
    }

    @PostMapping("/{idPromo}/article/{idArticle}")
    public void affecterPromotionAArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.affecterPromotionAArticle(idArticle, idPromo);
    }


    @PostMapping ("/{idPromo}/remove-article/{idArticle}")
    public void desaffecterPromotionDUnArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.desaffecterPromotionDUnArticle(idArticle, idPromo);
    }
    @PostMapping("/addpromo/{idArticle}")
    public void ajouterPromoEtAffecterAArticle(@RequestBody PromotionRequest promotionRequete,
                                               @PathVariable long idArticle) {

        // Convertir DTO → Entité
        Promotion promotion = Promotion.builder()
                .pourcentagePromo(promotionRequete.getPourcentagePromo())
                .dateDebutPromo(promotionRequete.getDateDebutPromo())
                .dateFinPromo(promotionRequete.getDateFinPromo())
                .build();

        promotionService.ajouterPromoEtAffecterAArticle(promotion, idArticle);
    }

}