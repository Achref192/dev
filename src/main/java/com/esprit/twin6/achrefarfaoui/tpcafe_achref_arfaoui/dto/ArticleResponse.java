package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Detail_Commande;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import jakarta.persistence.*;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    Long idArticle;
    String nomArticle;
    float prixArticle;
    TypeArticle typeArticle;
    List<PromotionResponse> promotions;
}