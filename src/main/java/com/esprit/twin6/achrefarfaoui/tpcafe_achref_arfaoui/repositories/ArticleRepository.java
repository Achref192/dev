package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Article;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    // 1. Nom exact
    List<Article> findByNomArticle(String nom);

    // 2. Type
    List<Article> findByTypeArticle(TypeArticle type);

    // 3. Prix exact
    List<Article> findByPrixArticle(float prix);

    // 4. Existence par nom
    boolean existsByNomArticle(String nom);

    // 5. Compter par type
    long countByTypeArticle(TypeArticle type);

    // 6. Nom contient + type spécifique
    List<Article> findByNomArticleContainingAndTypeArticle(String nom, TypeArticle type);

    // 7. Prix dans plage + type spécifique
    List<Article> findByPrixArticleBetweenAndTypeArticle(float min, float max, TypeArticle type);

    // 8. Nom commence par (insensible à la casse), tri par prix croissant
    List<Article> findByNomArticleIgnoreCaseStartingWithOrderByPrixArticleAsc(String prefix);

    // 9. Articles d’un type avec prix maximum
    List<Article> findTopByTypeArticleOrderByPrixArticleDesc(TypeArticle type);

    // 10. Nom ou type, tri prix décroissant
    List<Article> findByNomArticleOrTypeArticleOrderByPrixArticleDesc(String nom, TypeArticle type);

    // 11. Nom commence par préfixe
    List<Article> findByNomArticleStartingWith(String prefix);

    // 12. Nom se termine par suffixe
    List<Article> findByNomArticleEndingWith(String suffix);

    // 13. Articles sans type
    List<Article> findByTypeArticleIsNull();

    // 14. Articles avec prix renseigné
    List<Article> findByPrixArticleIsNotNull();

    // 15. Articles avec promotions actives
    // Attention : Assurez-vous que l'entité Promotion a un champ boolean 'active'
    @Query("""
       SELECT DISTINCT a 
       FROM Article a 
       JOIN a.promotions p
       WHERE p.dateDebutPromo <= CURRENT_DATE
         AND p.dateFinPromo >= CURRENT_DATE
       """)
    List<Article> findArticlesWithActivePromotions();


    // 16. Nom contient + prix dans plage
    List<Article> findByNomArticleContainingAndPrixArticleBetween(String nom, float min, float max);

}