package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ClientRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ClientResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        AdresseMapper.class,
        CarteFideliteMapper.class,
        CommandeMapper.class
})
public interface ClientMapper {

    @Mapping(target = "adress", source = "adress")
    @Mapping(target = "carte", source = "carte")
    @Mapping(target = "commande", source = "commande")
    ClientResponse toDto(Client client);

    List<ClientResponse> toDtoList(List<Client> clients);

    @Mapping(target = "idClient", ignore = true) // ID auto-généré
    @Mapping(target = "commande", ignore = true) // Commandes non présentes dans la requête
    Client toEntity(ClientRequest dto);
}
