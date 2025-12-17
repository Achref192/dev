package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.StatusCommande;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeRequest {
    LocalDate dateCommande;
    float totalCommande;
    StatusCommande statusCommande;
    Long clientId;
}
