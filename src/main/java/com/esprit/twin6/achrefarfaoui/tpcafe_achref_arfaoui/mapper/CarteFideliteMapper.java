package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.CarteFidelite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarteFideliteMapper {
    CarteFideliteResponse toDto(CarteFidelite carte);
    List<CarteFideliteResponse> toDtoList(List<CarteFidelite> cartes);
    CarteFidelite toEntity(CarteFideliteRequest dto);
    List<CarteFidelite>toentity2(List<CarteFideliteRequest> carteFidelites);
    List<CarteFideliteResponse>todto2(List<CarteFidelite> carteFidelites);
}