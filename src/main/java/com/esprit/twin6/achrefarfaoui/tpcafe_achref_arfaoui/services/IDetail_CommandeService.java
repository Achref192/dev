package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.Detail_CommandeResponse;

import java.util.List;

public interface IDetail_CommandeService {

    Detail_CommandeResponse addDetailCommande(Detail_CommandeRequest detailCommande);
    List<Detail_CommandeResponse>  saveDetailCommande(List<Detail_CommandeRequest> detailCommandes);
    public Detail_CommandeResponse selectDetailCommandeById(long id);
    List<Detail_CommandeResponse> selectAllDetailCommande();
    void deleteDetailCommande(Detail_CommandeRequest detailCommande);
    void deleteAllDetailCommande();
    void deleteDetailCommandeById(long id);
    long countingDetailCommande();
    boolean verifyDetailCommandeById(long id);

}