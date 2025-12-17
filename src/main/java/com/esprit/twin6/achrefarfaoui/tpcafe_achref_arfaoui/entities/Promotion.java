package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromotion;
    @Column(name = "pourcentagePromo")
    private String pourcentagePromo;
    @Temporal(TemporalType.DATE)
    private LocalDate dateDebutPromo;
    @Temporal(TemporalType.DATE)
    private LocalDate dateFinPromo;
    @ManyToMany(mappedBy = "promotions")
    List<Article> articles ;

}
