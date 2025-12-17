package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Detail_Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Detail_CommandeRepository extends JpaRepository<Detail_Commande, Long> {

    @Query(value = "SELECT * FROM detail_commande WHERE quantite = :qty", nativeQuery = true)
    List<Detail_Commande> findByQuantiteExact(int qty);

    // 2. Sous-total exact
    @Query(value = "SELECT * FROM detail_commande WHERE sous_total = :st", nativeQuery = true)
    List<Detail_Commande> findBySousTotalExact(float st);

    // 3. Compter quantité > X
    @Query(value = "SELECT COUNT(*) FROM detail_commande WHERE quantite > :qty", nativeQuery = true)
    long countQuantityGreater(int qty);

    // 4. Vérifier existence sous-total élevé
    @Query(value = "SELECT COUNT(*) > 0 FROM detail_commande WHERE sous_total > :st", nativeQuery = true)
    boolean existsBySousTotalGreater(float st);

    // 5. Quantité dans plage + sous-total >= min
    @Query(value = "SELECT * FROM detail_commande WHERE quantite BETWEEN :min AND :max AND sous_total >= :stMin",
            nativeQuery = true)
    List<Detail_Commande> findByQuantiteRangeAndSousTotal(int min, int max, float stMin);

    // 6. Sous-total dans plage trié par quantité
    @Query(value = "SELECT * FROM detail_commande WHERE sous_total BETWEEN :min AND :max ORDER BY quantite",
            nativeQuery = true)
    List<Detail_Commande> findBySousTotalRangeOrderByQty(float min, float max);

    // 7. Sous-total après promo dans plage
    @Query(value = "SELECT * FROM detail_commande WHERE sous_total_apres_promo BETWEEN :min AND :max",
            nativeQuery = true)
    List<Detail_Commande> findBySousTotalPromoRange(float min, float max);

    // 8. Quantité OU sous-total minimum
    @Query(value = "SELECT * FROM detail_commande WHERE quantite >= :qty OR sous_total >= :st",
            nativeQuery = true)
    List<Detail_Commande> findByQtyOrSousTotalMin(int qty, float st);

    // 9. Top 5 détails les plus chers
    @Query(value = "SELECT * FROM detail_commande ORDER BY sous_total DESC LIMIT 5", nativeQuery = true)
    List<Detail_Commande> findTop5Expensive();

    // 10. Sans quantité
    @Query(value = "SELECT * FROM detail_commande WHERE quantite IS NULL", nativeQuery = true)
    List<Detail_Commande> findQuantityNull();

    // 11. Sous-total après promo renseigné
    @Query(value = "SELECT * FROM detail_commande WHERE sous_total_apres_promo IS NOT NULL", nativeQuery = true)
    List<Detail_Commande> findSousTotalPromoNotNull();

    // 12. Avec commande et article (JOIN)
    @Query(value = "SELECT * FROM detail_commande dc " +
            "JOIN commande c ON c.id_commande = dc.commande_id " +
            "JOIN article a ON a.id_article = dc.article_id",
            nativeQuery = true)
    List<Detail_Commande> findWithCommandeAndArticle();
}