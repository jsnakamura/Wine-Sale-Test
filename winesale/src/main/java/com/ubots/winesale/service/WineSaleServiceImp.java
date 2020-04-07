package com.ubots.winesale.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Wine;
import com.ubots.winesale.repository.ClientRepository;
import com.ubots.winesale.repository.SaleRepository;
import com.ubots.winesale.repository.WineRepository;

@Service
public class WineSaleServiceImp implements WineSaleService {

	private ClientRepository clientRepository;
	private SaleRepository saleRepository;
	private WineRepository wineRepository;

	@Autowired
	public WineSaleServiceImp(ClientRepository clientRepository, SaleRepository saleRepository,
			WineRepository wineRepository) {
		this.clientRepository = clientRepository;
		this.saleRepository = saleRepository;
		this.wineRepository = wineRepository;
	}

	@Override
	public List<Client> listAllByTotalValue() {
		return null;
		
	}

	@Override
	public Client getHighestSale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getLoyalestClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wine getWineRecomendation(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
