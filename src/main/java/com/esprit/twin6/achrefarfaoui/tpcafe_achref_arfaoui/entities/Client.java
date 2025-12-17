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
@Table(name = "client")
public class Client {
    @Id //Auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    @Column(name = "firstName", length = 50, nullable = false)
    private  String nom; //first_name
    @Column(name = "lastName", length = 50, nullable = false)
    private String prenom; //first_name
    @Temporal(TemporalType.DATE)
    private LocalDate dateNaissance;

    @OneToOne
    Adresse adress;
    @OneToOne
    CarteFidelite carte;
    @OneToMany(mappedBy = "client")
    List<Commande> commande;
}
