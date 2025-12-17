package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "detail_commande")
public class Detail_Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailCommande;
    @Column(name = "quantiteArticle")
    private int quantiteArticle;
    @Column(name = "sousTotalDetailArticle")
    private float sousTotalDetailArticle;
    @Column(name = "sousTotalDetailArticleApresPromo")
    private float sousTotalDetailArticleApresPromo;

    @ManyToOne
    Commande commande;
    @ManyToOne
    Article article;
}
