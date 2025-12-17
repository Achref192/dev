package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Adresse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseResponse toDto(Adresse adresse);
    List<AdresseResponse> toDtoList(List<Adresse> adresses);
    Adresse toEntity(AdresseRequest dto);
    List<AdresseResponse> todto2(List<Adresse> adresses);
    List<Adresse> toentity2(List<AdresseRequest> adresses);


}

