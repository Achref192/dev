package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Adresse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;

import java.util.List;

public interface IAdresseService {

    AdresseResponse addAdresse(AdresseRequest adresse);
    List<AdresseResponse>saveAdresses(List<AdresseRequest> adresses);
    public Adresse selectAdresseByIdWithOrElse(long id);
    public AdresseResponse selectAdresseByIDwithGet(long id);
    List<AdresseResponse> selectAllAdresses();
    void deleteAdresse(AdresseRequest adresse);
    void deleteAllAdresses();
    void deleteAdresseById(long id);
    long countingAdresse();
    boolean verifyAdresseById(long id);

    List<AdresseResponse> findByVille(String ville);
    List<AdresseResponse> findByCodePostal(Integer codePostal);
    long countByVille(String ville);
    void deleteByVille(String ville);
    List<AdresseResponse> findByVilleAndCodePostal(String ville, Integer codePostal);
    List<AdresseResponse> findByRueContainingIgnoreCaseAndVille(String motRue, String ville);
    List<AdresseResponse> findByVilleIn(List<String> villes);
    List<AdresseResponse> findByCodePostalBetween(Integer min, Integer max);
    List<AdresseResponse> findByCodePostalGreaterThan(Integer cp);
    List<AdresseResponse> findByCodePostalGreaterThanEqual(Integer cp);
    List<AdresseResponse> findByCodePostalLessThan(Integer cp);
    List<AdresseResponse> findByCodePostalLessThanEqual(Integer cp);
    List<AdresseResponse> findByRueStartsWithAndVille(String prefix, String ville);
    List<AdresseResponse> findByRueStartsWith(String prefix);
    List<AdresseResponse> findByVilleEndsWith(String suffix);
    List<AdresseResponse> findByRueIsNull();
    List<AdresseResponse> findByVilleIsNotNull();
}
