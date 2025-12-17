package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.restController;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Adresse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.IAdresseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@Tag(name = "📍 Adresses", description = "Gestion des adresses des clients")
@RestController
@RequestMapping("adresses")
@AllArgsConstructor
public class AdresseRestController {

    private final IAdresseService adresseService;

    @Operation(summary = "Récupérer toutes les adresses", description = "Retourne la liste complète de toutes les adresses")
    @GetMapping
    public List<AdresseResponse> selectAllAdresse() {
        return adresseService.selectAllAdresses();
    }

    @Operation(summary = "Récupérer une adresse par ID avec paramètre", description = "Retourne une adresse spécifique selon son identifiant (via paramètre)")
    @GetMapping("/selectById2")
    public Adresse selectid2(@RequestParam long id) {
        return adresseService.selectAdresseByIdWithOrElse(id);
    }

    @Operation(summary = "Récupérer une adresse par ID avec chemin", description = "Retourne une adresse spécifique selon son identifiant (via chemin)")
    @GetMapping("selectByID/{id}")
    public AdresseResponse selectAdresse(@PathVariable long id) {
        return adresseService.selectAdresseByIDwithGet(id);
    }

    @Operation(summary = "Ajouter une nouvelle adresse", description = "Crée une nouvelle adresse dans le système")
    @PostMapping
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresse) {
        return adresseService.addAdresse(adresse);
    }

    @Operation(summary = "Ajouter une liste d'adresses", description = "Ajoute plusieurs adresses en une seule opération")
    @PostMapping("/list")
    public List<AdresseResponse> addAdresses(@RequestBody List<AdresseRequest> adresses) {
        return adresseService.saveAdresses(adresses);
    }

    @Operation(summary = "Supprimer une adresse", description = "Supprime une adresse en la passant dans le corps de la requête")
    @DeleteMapping("/del")
    public void deleteAdresse(@RequestBody AdresseRequest adresse) {
        adresseService.deleteAdresse(adresse);
    }

    @Operation(summary = "Supprimer une adresse par ID", description = "Supprime une adresse spécifique selon son identifiant")
    @DeleteMapping("delete/{id}")
    public void deleteAdresse(@PathVariable long id) {
        adresseService.deleteAdresseById(id);
    }

    @Operation(summary = "Supprimer toutes les adresses", description = "Vide complètement la liste des adresses")
    @DeleteMapping("all")
    public void deleteAllAdresse() {
        adresseService.deleteAllAdresses();
    }

    @Operation(summary = "Compter le nombre d'adresses", description = "Retourne le nombre total d'adresses dans le système")
    @GetMapping("count")
    public long count() {
        return adresseService.countingAdresse();
    }

    @Operation(summary = "Vérifier l'existence d'une adresse", description = "Retourne true si une adresse existe avec l'ID spécifié, false sinon")
    @GetMapping("exist/{id}")
    public boolean exist(@PathVariable long id) {
        return adresseService.verifyAdresseById(id);
    }
}