package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.PromotionResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Article;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.PromotionMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.ArticleRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService {

    private PromotionRepository promotionRepository;
    private PromotionMapper promotionMapper;
    private ArticleRepository articleRepository;

    @Override
    public PromotionResponse addPromotion(PromotionRequest promotion) {
        Promotion P = promotionMapper.toentity(promotion);
        Promotion p = promotionRepository.save(P);
        return promotionMapper.toDto(p);
    }

    @Override
    public List<PromotionResponse> savePromotion(List<PromotionRequest> promotions) {
        List<Promotion> list = promotionMapper.toentity1(promotions);
        List<Promotion> l = promotionRepository.saveAll(list);
        return promotionMapper.toDto1(l);
    }

    @Override
    public PromotionResponse selectPromotionById(long id) {
        Promotion p = promotionRepository.findById(id).get();
        return promotionMapper.toDto(p);
    }

    @Override
    public List<PromotionResponse> selectAllPromotion() {
        List<Promotion> list = promotionRepository.findAll();
        return promotionMapper.toDto1(list);
    }

    @Override
    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);

    }

    @Override
    public void deleteAllPromotion() {
        promotionRepository.deleteAll();

    }

    @Override
    public void deletePromotion(PromotionRequest promotion) {
        Promotion p = promotionMapper.toentity(promotion);
        promotionRepository.delete(p);

    }

    @Override
    public long countingPromotion() {
        return promotionRepository.count();
    }

    @Override
    public boolean verifyPromotionById(long id) {
        return promotionRepository.existsById(id);
    }

    @Override
    public void affecterPromotionAArticle(long idArticle, long idPromo) {

        Article article = articleRepository.findById(idArticle)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        Promotion promotion = promotionRepository.findById(idPromo)
                .orElseThrow(() -> new RuntimeException("Promotion introuvable"));

        if (article.getPromotions() == null) {
            article.setPromotions(new ArrayList<>());
        }
        article.getPromotions().add(promotion);

        articleRepository.save(article);
    }

    @Override
    public void desaffecterPromotionDUnArticle(long idArticle, long idPromo) {

        Article article = articleRepository.findById(idArticle)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        Promotion promotion = promotionRepository.findById(idPromo)
                .orElseThrow(() -> new RuntimeException("Promotion introuvable"));

        if (article.getPromotions() != null) {
            article.getPromotions().remove(promotion);
        }

        articleRepository.save(article);
    }

    @Override
    public void ajouterPromoEtAffecterAArticle(Promotion p, long idArticle) {

        Article article = articleRepository.findById(idArticle).get();

        // Ajouter la promo à l’article //travaille avec cascade
        article.getPromotions().add(p);

        // Grâce au cascade, ça sauvegarde promotion + la relation
        articleRepository.save(article);
    }

}



