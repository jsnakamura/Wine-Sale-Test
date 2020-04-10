package com.ubots.winesale.service;

import java.util.List;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Wine;

public interface WineSaleService {

	public List<Client> listAllByTotalValue();

	public Client getHighestSale();

	public List<Client> getLoyalestClients();

	public Wine getWineRecomendation(int id);
}
