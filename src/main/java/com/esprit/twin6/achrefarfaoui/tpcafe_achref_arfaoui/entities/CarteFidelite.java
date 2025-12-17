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
@Table(name = "carteFidelite")
public class CarteFidelite {

    @Id //Auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarteFidelite;
    @Column(name = "pointsAccumules")
    private int pointsAccumules;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreation;
    @OneToOne (mappedBy ="carte")
    Client client;

}
