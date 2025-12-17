package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    @Column(name = "nomArticle")
    private String nomArticle;
    @Column(name = "prixArticle")
    private float prixArticle;

    @Enumerated(EnumType.STRING)
    private TypeArticle typeArticle;

    @OneToMany(mappedBy = "article")
    List<Detail_Commande> detailC;
    @ManyToMany
    List<Promotion> promotions;
}
