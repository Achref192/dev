
package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequest {
    String nomArticle;
    float prixArticle;
    TypeArticle typeArticle;
    List<Long> promotionsIds;
}
