package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.StatusCommande;
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
public class CommandeResponse {
    Long idCommande;
    LocalDate dateCommande;
    float totalCommande;
    StatusCommande statusCommande;
    List<Detail_CommandeResponse> detailC;
}