package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientRequest {
    String nom;
    String prenom;
    LocalDate dateNaissance;
    AdresseRequest adress;
    CarteFideliteRequest carte;
}
