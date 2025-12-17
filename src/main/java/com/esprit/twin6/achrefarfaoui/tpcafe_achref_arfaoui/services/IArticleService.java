package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;

import java.util.List;

public interface IArticleService {

    ArticleResponse addArticle(ArticleRequest article);
    List<ArticleResponse> saveArticles (List<ArticleRequest> articles);
    ArticleResponse selectArticleById(long id);
    List<ArticleResponse> selectAllArticles();
    void deleteArticle(ArticleRequest article);
    void deleteAllArticles();
    void deleteArticleById(long id);
    long countingArticles();
    boolean verifyArticleById(long id);
    boolean deleteArticle(Long id);

}