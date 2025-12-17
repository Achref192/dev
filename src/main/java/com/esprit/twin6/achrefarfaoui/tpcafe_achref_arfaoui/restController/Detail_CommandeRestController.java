package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.restController;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.IDetail_CommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detailcommande")
@Tag(name = "DetailCommande", description = "Gestion du détail de commande")
@AllArgsConstructor
public class Detail_CommandeRestController {

    private final IDetail_CommandeService detailCommandeService;

    // --- CRUD de base ---

    @Operation(summary = "Récupérer tous les détails de commande", description = "Retourne la liste complète de tous les détails de commande")
    @GetMapping
    public List<Detail_CommandeResponse> selectAllDetailCommande() {
        return detailCommandeService.selectAllDetailCommande();
    }

    @Operation(summary = "Ajouter un nouveau détail de commande", description = "Crée un nouveau détail de commande dans le système")
    @PostMapping
    public Detail_CommandeResponse addDetailCommande(@RequestBody Detail_CommandeRequest detailCommande) {
        return detailCommandeService.addDetailCommande(detailCommande);
    }

    @Operation(summary = "Ajouter une liste de détails de commande", description = "Ajoute plusieurs détails de commande en une seule opération")
    @PostMapping("/list")
    public List<Detail_CommandeResponse> addDetailCommandes(@RequestBody List<Detail_CommandeRequest> detailCommandes) {
        return detailCommandeService.saveDetailCommande(detailCommandes);
    }

    @Operation(summary = "Récupérer un détail de commande par ID avec paramètre", description = "Retourne un détail de commande spécifique selon son identifiant (via paramètre)")
    @GetMapping("/selectById2")
    public Detail_CommandeResponse selectDetailCommandeById2(@RequestParam long id) {
        return detailCommandeService.selectDetailCommandeById(id);
    }

    @Operation(summary = "Récupérer un détail de commande par ID avec chemin", description = "Retourne un détail de commande spécifique selon son identifiant (via chemin)")
    @GetMapping("selectByID/{id}")
    public Detail_CommandeResponse selectDetailCommandeByID(@PathVariable long id) {
        return detailCommandeService.selectDetailCommandeById(id);
    }

    @Operation(summary = "Supprimer un détail de commande", description = "Supprime un détail de commande en le passant dans le corps de la requête")
    @DeleteMapping("/del")
    public void deleteDetailCommande(@RequestBody Detail_CommandeRequest detailCommande) {
        detailCommandeService.deleteDetailCommande(detailCommande);
    }

    @Operation(summary = "Supprimer un détail de commande par ID", description = "Supprime un détail de commande spécifique selon son identifiant")
    @DeleteMapping("delete/{id}")
    public void deleteDetailCommandeByID(@PathVariable long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }

    @Operation(summary = "Supprimer tous les détails de commande", description = "Vide complètement la liste des détails de commande")
    @DeleteMapping("all")
    public void deleteAllDetailCommandes() {
        detailCommandeService.deleteAllDetailCommande();
    }

    @Operation(summary = "Compter le nombre de détails de commande", description = "Retourne le nombre total de détails de commande dans le système")
    @GetMapping("count")
    public long countDetailCommande() {
        return detailCommandeService.countingDetailCommande();
    }

    @Operation(summary = "Vérifier l'existence d'un détail de commande", description = "Retourne true si un détail de commande existe avec l'ID spécifié, false sinon")
    @GetMapping("exist/{id}")
    public boolean existDetailCommande(@PathVariable long id) {
        return detailCommandeService.verifyDetailCommandeById(id);
    }
}