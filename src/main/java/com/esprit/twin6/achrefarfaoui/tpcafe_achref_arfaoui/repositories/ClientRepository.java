package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByNom(String nom);

    List<Client> findByPrenom(String prenom);

    Client findByNomAndPrenom(String nom, String prenom);

    boolean existsByNom(String nom);

    long countByDateNaissanceAfter(LocalDate date);

    List<Client> findByNomContainingOrPrenomContaining(String nomPart, String prenomPart);

    List<Client> findByNomContainingAndPrenomContaining(String nomPart, String prenomPart);

    List<Client> findByDateNaissanceBetween(LocalDate d1, LocalDate d2);

    List<Client> findByNomStartsWithAndDateNaissanceBefore(String prefix, LocalDate date);

    List<Client> findByAdressVille(String ville);

    List<Client> findByNomContainingOrderByPrenomAsc(String nomPart);

    List<Client> findByNomContainingOrderByPrenomDesc(String nomPart);

    List<Client> findByNomStartsWith(String prefix);

    List<Client> findByPrenomEndsWith(String suffix);

    List<Client> findByDateNaissanceIsNull();

    List<Client> findByAdressIsNotNull();

    List<Client> findByAdressVilleIn(List<String> villes);

    @Query("SELECT c FROM Client c WHERE c.carte.pointsAccumules > :pts")
    List<Client> findClientsWithCartePointsGreaterThan(@Param("pts") int pts);

    @Query("SELECT c FROM Client c WHERE c.carte.pointsAccumules >= :pts")
    List<Client> findClientsWithCartePointsGreaterOrEqual(@Param("pts") int pts);

    @Query("SELECT c FROM Client c WHERE c.carte.pointsAccumules BETWEEN :min AND :max")
    List<Client> findClientsWithCartePointsBetween(@Param("min") int min, @Param("max") int max);

    @Query("SELECT DISTINCT c FROM Client c " +
            "JOIN c.commande cmd " +
            "JOIN cmd.detailC d " +
            "JOIN d.article a " +
            "WHERE a.nomArticle = :nom")
    List<Client> findClientsWhoOrderedArticleNamed(@Param("nom") String nom);

    @Query("SELECT DISTINCT c FROM Client c " +
            "JOIN c.commande cmd " +
            "JOIN cmd.detailC d " +
            "JOIN d.article a " +
            "WHERE (c.nom LIKE %:str% OR c.prenom LIKE %:str%) " +
            "AND a.typeArticle = :type")
    List<Client> findClientsWithNameContainingAndOrderedArticleType(
            @Param("str") String str,
            @Param("type") TypeArticle type);

}
