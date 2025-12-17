package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Adresse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseResponse {
    Long idAdresse;
    String rue;
    String ville;
    String codePostal;


}

