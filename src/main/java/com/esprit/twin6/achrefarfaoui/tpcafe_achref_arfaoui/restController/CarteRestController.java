package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.restController;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.CarteFidelite;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.ICarteFideliteService;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.IClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Gestion des Cartes Fidélité", description = "API CRUD pour la gestion des cartes fidélité")
@RestController
@RequestMapping("cartefidelite")
@AllArgsConstructor
public class CarteRestController {

    private final ICarteFideliteService service;
    private ICarteFideliteService carteFideliteService;
    private final IClientService clientService;



    @Operation(summary = "Récupérer toutes les cartes fidélité", description = "Retourne la liste complète de toutes les cartes fidélité")
    @GetMapping
    public List<CarteFideliteResponse> selectAllCarteFidelite() {
        return carteFideliteService.selectAllCarteFidelites();
    }

    @Operation(summary = "Ajouter une nouvelle carte fidélité", description = "Crée une nouvelle carte fidélité dans le système")
    @PostMapping
    public CarteFideliteResponse addCarteFidelite(@RequestBody CarteFideliteRequest carteFidelite) {
        return carteFideliteService.addCarteFidelite(carteFidelite);
    }

    @Operation(summary = "Ajouter une liste de cartes fidélité", description = "Ajoute plusieurs cartes fidélité en une seule opération")
    @PostMapping("/list")
    public List<CarteFideliteResponse> addCarteFidelites(@RequestBody List<CarteFideliteRequest> carteFidelites) {
        return carteFideliteService.saveCarteFidelites(carteFidelites);
    }

    @Operation(summary = "Récupérer une carte fidélité par ID avec paramètre", description = "Retourne une carte fidélité spécifique selon son identifiant (via paramètre)")
    @GetMapping("/selectById2")
    public CarteFideliteResponse selectCarteFideliteById2(@RequestParam long id) {
        return carteFideliteService.selectCarteFideliteById(id);
    }

    @Operation(summary = "Récupérer une carte fidélité par ID avec chemin", description = "Retourne une carte fidélité spécifique selon son identifiant (via chemin)")
    @GetMapping("selectByID/{id}")
    public CarteFideliteResponse selectCarteFideliteByID(@PathVariable long id) {
        return carteFideliteService.selectCarteFideliteById(id);
    }

    @Operation(summary = "Supprimer une carte fidélité", description = "Supprime une carte fidélité en la passant dans le corps de la requête")
    @DeleteMapping("/del")
    public void deleteCarteFidelite(@RequestBody CarteFideliteRequest carteFidelite) {
        carteFideliteService.deleteCarteFidelite(carteFidelite);
    }

    @Operation(summary = "Supprimer une carte fidélité par ID", description = "Supprime une carte fidélité spécifique selon son identifiant")
    @DeleteMapping("delete/{id}")
    public void deleteCarteFideliteByID(@PathVariable long id) {
        carteFideliteService.deleteCarteFideliteById(id);
    }

    @Operation(summary = "Supprimer toutes les cartes fidélité", description = "Vide complètement la liste des cartes fidélité")
    @DeleteMapping("all")
    public void deleteAllCarteFidelite() {
        carteFideliteService.deleteAllCarteFidelites();
    }

    @Operation(summary = "Compter le nombre de cartes fidélité", description = "Retourne le nombre total de cartes fidélité dans le système")
    @GetMapping("count")
    public Long countCarteFidelite() {
        return carteFideliteService.countingCarteFidelites();
    }

    @Operation(summary = "Vérifier l'existence d'une carte fidélité", description = "Retourne true si une carte fidélité existe avec l'ID spécifié, false sinon")
    @GetMapping("exist/{id}")
    public Boolean exist(@PathVariable Long id) {
        return carteFideliteService.verifyCarteFideliteById(id);
    }

    @PostMapping("/add-with-client")
    public void ajouterCarteEtClient(@RequestBody CarteFidelite carte) {
        clientService.ajouterClienteEtCarteFidelite(carte);
    }
}