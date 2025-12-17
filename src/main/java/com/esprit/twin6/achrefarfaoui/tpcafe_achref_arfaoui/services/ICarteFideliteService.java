package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.CarteFideliteResponse;

import java.time.LocalDate;
import java.util.List;

public interface ICarteFideliteService {

    CarteFideliteResponse addCarteFidelite(CarteFideliteRequest carteFidelite);
    List<CarteFideliteResponse> saveCarteFidelites (List<CarteFideliteRequest> carteFidelites);
    CarteFideliteResponse selectCarteFideliteById(long id);
    List<CarteFideliteResponse> selectAllCarteFidelites();
    void deleteCarteFidelite(CarteFideliteRequest carteFidelite);
    void deleteAllCarteFidelites();
    void deleteCarteFideliteById(long id);
    long countingCarteFidelites();
    boolean verifyCarteFideliteById(long id);
    void incrementerPointsAnniversaire();
}