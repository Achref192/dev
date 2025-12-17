package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Article;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Commande;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Detail_Commande;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.Detail_CommandeMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.ArticleRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.CommandeRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.Detail_CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Detail_CommandeService implements IDetail_CommandeService {

    private final Detail_CommandeRepository detailCommandeRepository;
    private final Detail_CommandeMapper detailCommandeMapper;
    private final ArticleRepository articleRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public Detail_CommandeResponse addDetailCommande(Detail_CommandeRequest detailCommande) {
        Detail_Commande D = detailCommandeMapper.toEntity(detailCommande);
        Detail_Commande d= detailCommandeRepository.save(D);
        return detailCommandeMapper.toDto(d);
    }

    @Override
    public List<Detail_CommandeResponse> saveDetailCommande(List<Detail_CommandeRequest> detailCommandes) {
        List<Detail_Commande>list=detailCommandeMapper.toEntity1(detailCommandes);
        List<Detail_Commande>D= detailCommandeRepository.saveAll(list);
        return detailCommandeMapper.toDto1(D);
    }

    @Override
    public Detail_CommandeResponse selectDetailCommandeById(long id) {
        Detail_Commande d = detailCommandeRepository.findById(id).get();
        return detailCommandeMapper.toDto(d);
    }

    @Override
    public List<Detail_CommandeResponse> selectAllDetailCommande() {
        List<Detail_Commande> list =detailCommandeRepository.findAll();
        return detailCommandeMapper.toDto1(list);
    }

    @Override
    public void deleteDetailCommande(Detail_CommandeRequest detailCommande) {
        Detail_Commande D = detailCommandeMapper.toEntity(detailCommande);
        detailCommandeRepository.delete(D);

    }

    @Override
    public void deleteAllDetailCommande() {
        detailCommandeRepository.deleteAll();

    }

    @Override
    public void deleteDetailCommandeById(long id) {
        detailCommandeRepository.deleteById(id);

    }

    @Override
    public long countingDetailCommande() {
        return detailCommandeRepository.count();
    }

    @Override
    public boolean verifyDetailCommandeById(long id) {
        return detailCommandeRepository.existsById(id);
    }
}
