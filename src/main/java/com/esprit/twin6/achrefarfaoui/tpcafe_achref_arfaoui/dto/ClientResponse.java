package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {
    Long idClient;
    String nom;
    String prenom;
    LocalDate dateNaissance;

    AdresseResponse adress;
    CarteFideliteResponse carte;
    List<CommandeResponse> commande;
}
