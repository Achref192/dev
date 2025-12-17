package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.restController;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services.IArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
@AllArgsConstructor
public class ArticleRestController {

    private IArticleService articleService;

    @Operation(summary = "Récupérer tous les articles", description = "Retourne la liste complète de tous les articles disponibles")
    @GetMapping
    public List<ArticleResponse> selectAllArticle() {
        return articleService.selectAllArticles();
    }

    @Operation(summary = "Récupérer un article par ID", description = "Retourne un article spécifique selon son identifiant")
    @GetMapping("selectByID/{id}")
    public ArticleResponse selectArticle(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    @Operation(summary = "Ajouter un nouvel article", description = "Crée un nouvel article dans le système")
    @PostMapping("addarticle")
    public ArticleResponse addArticle(@RequestBody ArticleRequest article) {
        return articleService.addArticle(article);
    }

    @Operation(summary = "Ajouter une liste d'articles", description = "Ajoute plusieurs articles en une seule opération")
    @PostMapping("addall")
    public List<ArticleResponse> addArticleList(@RequestBody List<ArticleRequest> articles) {
        return articleService.saveArticles(articles);
    }

    @Operation(summary = "Supprimer un article", description = "Supprime un article en le passant dans le corps de la requête")
    @DeleteMapping("/dela")
    public void deleteArticle(@RequestBody ArticleRequest article) {
        articleService.deleteArticle(article);
    }

    @Operation(summary = "Supprimer un article par ID", description = "Supprime un article spécifique selon son identifiant")
    @DeleteMapping("delete/{id}")
    public void deleteArticleByID(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    @Operation(summary = "Supprimer tous les articles", description = "Vide complètement la liste des articles")
    @DeleteMapping("all")
    public void deleteAllArticle() {
        articleService.deleteAllArticles();
    }

    @Operation(summary = "Compter le nombre d'articles", description = "Retourne le nombre total d'articles dans le système")
    @GetMapping("count")
    public Long countArticles() {
        return articleService.countingArticles();
    }

    @Operation(summary = "Vérifier l'existence d'un article", description = "Retourne true si un article existe avec l'ID spécifié, false sinon")
    @GetMapping("exist/{id}")
    public Boolean existArticle(@PathVariable long id) {
        return articleService.verifyArticleById(id);
    }
}