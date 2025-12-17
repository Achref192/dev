package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface IPromotionService {
    PromotionResponse addPromotion(PromotionRequest promotion);
    List<PromotionResponse> savePromotion(List<PromotionRequest> promotions);
    public PromotionResponse selectPromotionById(long id);
    List<PromotionResponse> selectAllPromotion();
    void deletePromotionById(long id);
    void deleteAllPromotion();
    void deletePromotion(PromotionRequest promotion);
    long countingPromotion();
    boolean verifyPromotionById(long id);
    void affecterPromotionAArticle(long idArticle, long idPromo);
    void desaffecterPromotionDUnArticle(long idArticle, long idPromo);
    void ajouterPromoEtAffecterAArticle(Promotion p, long idArticle);
}