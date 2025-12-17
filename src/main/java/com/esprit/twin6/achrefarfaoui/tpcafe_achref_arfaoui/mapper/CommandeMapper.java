package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { Detail_CommandeMapper.class })
public interface CommandeMapper {

    Commande toentity(CommandeRequest commandeRequete);
    CommandeResponse toDTO(Commande commande);
    List<Commande> toentityList(List<CommandeRequest> commandeList);
    List<CommandeResponse> toDTOList(List<Commande> commandeList);

}
