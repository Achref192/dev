package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.AdresseResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Adresse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.AdresseMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.AdresseRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AdresseService implements IAdresseService {


        private final AdresseRepository adresseRepository;
        private final AdresseMapper adresseMapper;
    private final ClientRepository clientRepository;


    @Override
    public AdresseResponse addAdresse(AdresseRequest adresse) {
        Adresse A= adresseMapper.toEntity(adresse);
        Adresse B= adresseRepository.save(A);
        return adresseMapper.toDto(B);
    }

    @Override
    public List<AdresseResponse> saveAdresses(List<AdresseRequest> adresses) {
        List<Adresse>a=adresseMapper.toentity2(adresses);
        List<Adresse>A= adresseRepository.saveAll(a);
        return adresseMapper.todto2(A);

    }

    @Override

    public Adresse selectAdresseByIdWithOrElse(long id) {

        return adresseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("adresse not find"+id)); // --------------> s'il nexiste pas une adresse avec ce id elle return un objet personaliser
        //return adresseRository.findby id.get() ---------->s'il nexiste pas une adresse avec ce id elle return un objet vide
    }
    public AdresseResponse selectAdresseByIDwithGet(long id) {
        Adresse a =adresseRepository.findById(id).get();
        return adresseMapper.toDto(a);
    }

    @Override
    public List<AdresseResponse> selectAllAdresses() {
        List<Adresse>a=adresseRepository.findAll();
        return adresseMapper.todto2(a);
    }

    @Override
    public void deleteAdresse(AdresseRequest adresse) {

        Adresse a =adresseMapper.toEntity(adresse);
        adresseRepository.delete(a);

    }

    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();

    }

    @Override
    public void deleteAdresseById(long id) {
        adresseRepository.deleteById(id);

    }

    @Override
    public long countingAdresse() {
        return adresseRepository.count();
    }

    @Override
    public boolean verifyAdresseById(long id) {
        return adresseRepository.existsById(id);
    }


    /// ////////////////////////////////////

    @Override
    public List<AdresseResponse> findByVille(String ville) {
        return adresseRepository.findByVille(ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostal(Integer codePostal) {
        return adresseRepository.findByCodePostal(codePostal)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countByVille(String ville) {
        return adresseRepository.countByVille(ville);
    }

    @Override
    public void deleteByVille(String ville) {
        adresseRepository.deleteByVille(ville);
    }

    @Override
    public List<AdresseResponse> findByVilleAndCodePostal(String ville, Integer codePostal) {
        return adresseRepository.findByVilleAndCodePostal(ville, codePostal)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueContainingIgnoreCaseAndVille(String motRue, String ville) {
        return adresseRepository.findByRueIgnoreCaseContainingAndVilleIgnoreCase(motRue, ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleIn(List<String> villes) {
        return adresseRepository.findByVilleIn(villes)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalBetween(Integer min, Integer max) {
        return adresseRepository.findByCodePostalBetween(min, max)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalGreaterThan(Integer cp) {
        return adresseRepository.findByCodePostalGreaterThan(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalGreaterThanEqual(Integer cp) {
        return adresseRepository.findByCodePostalGreaterThanEqual(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalLessThan(Integer cp) {
        return adresseRepository.findByCodePostalLessThan(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalLessThanEqual(Integer cp) {
        return adresseRepository.findByCodePostalLessThanEqual(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueStartsWithAndVille(String prefix, String ville) {
        return adresseRepository.findByRueStartsWithAndVilleOrderByCodePostal(prefix, ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueStartsWith(String prefix) {
        return adresseRepository.findByRueStartsWith(prefix)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleEndsWith(String suffix) {
        return adresseRepository.findByVilleEndsWith(suffix)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueIsNull() {
        return adresseRepository.findByRueIsNull()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleIsNotNull() {
        return adresseRepository.findByVilleIsNotNull()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }


}
