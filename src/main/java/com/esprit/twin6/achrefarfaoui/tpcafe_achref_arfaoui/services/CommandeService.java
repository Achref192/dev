package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CommandeResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Client;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Commande;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.CommandeMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.ClientRepository;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;
    private final ClientRepository clientRepository;

    @Override
    public CommandeResponse addCommande(CommandeRequest commande) {
        Commande C =commandeMapper.toentity(commande);
        Commande c= commandeRepository.save(C);
        return commandeMapper.toDTO(c);
    }

    @Override
    public List<CommandeResponse> saveCommandes(List<CommandeRequest> commandes) {
        List<Commande>list = commandeMapper.toentityList(commandes);
        List<Commande>lists= commandeRepository.saveAll(list);
        return commandeMapper.toDTOList(lists);
    }

    @Override
    public CommandeResponse selectCommandeById(long id) {
        Commande C= commandeRepository.findById(id).get();
        return commandeMapper.toDTO(C);
    }

    @Override
    public List<CommandeResponse> selectAllCommandes() {
        List<Commande> list = commandeRepository.findAll();
        return commandeMapper.toDTOList(list);
    }

    @Override
    public void deleteCommande(CommandeRequest commande) {
        Commande C = commandeMapper.toentity(commande);
        commandeRepository.delete(C);

    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();

    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);

    }

    @Override
    public long countingCommandes() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifyCommandeById(long id) {
        return commandeRepository.existsById(id);
    }
}
