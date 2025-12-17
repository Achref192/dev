package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.StatusCommande;
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
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCommande;
    @Column(name = "totalCommande")
    private float totalCommande;
    @Enumerated(EnumType.STRING)
    private StatusCommande statusCommande;
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "commande")
    List<Detail_Commande> detailC;

}
