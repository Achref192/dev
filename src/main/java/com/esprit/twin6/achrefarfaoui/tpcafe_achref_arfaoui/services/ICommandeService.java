package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeResponse;

import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {

    CommandeResponse addCommande(CommandeRequest commande);

    List<CommandeResponse> saveCommandes(List<CommandeRequest> commandes);

    public CommandeResponse selectCommandeById(long id);

    List<CommandeResponse> selectAllCommandes();

    void deleteCommande(CommandeRequest commande);

    void deleteAllCommandes();

    void deleteCommandeById(long id);

    long countingCommandes();

    boolean verifyCommandeById(long id);
}