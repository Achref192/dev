package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion toentity(PromotionRequest promotion);
    PromotionResponse toDto(Promotion promotion);

    List<Promotion>toentity1(List<PromotionRequest> promotion);
    List<PromotionResponse> toDto1(List<Promotion> promotion);
}
