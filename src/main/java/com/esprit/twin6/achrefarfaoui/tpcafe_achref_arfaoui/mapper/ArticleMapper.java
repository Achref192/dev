package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    // Article -> ArticleResponse
    ArticleResponse todto(Article article);

    // ArticleRequest -> Article
    Article toentity(ArticleRequest articleRequete);

    // List<Article> -> List<ArticleResponse>
    List<ArticleResponse> todto2(List<Article> articles);

    // List<ArticleRequest> -> List<Article>
    List<Article> toentity2(List<ArticleRequest> articleRequetes);
}
