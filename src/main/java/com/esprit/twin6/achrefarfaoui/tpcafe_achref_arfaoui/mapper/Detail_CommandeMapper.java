package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Detail_Commande;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ArticleMapper.class })
public interface Detail_CommandeMapper {
    Detail_Commande toEntity(Detail_CommandeRequest detailCommandeRequtes);
    Detail_CommandeResponse toDto(Detail_Commande detailCommande);

    List<Detail_CommandeResponse> toDto1(List<Detail_Commande> detailCommandeList);
    List<Detail_Commande>toEntity1(List<Detail_CommandeRequest> detailCommandeRequteses);
}

