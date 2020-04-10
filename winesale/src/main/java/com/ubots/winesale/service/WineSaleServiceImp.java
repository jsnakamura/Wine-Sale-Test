package com.ubots.winesale.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Sale;
import com.ubots.winesale.entity.Wine;
import com.ubots.winesale.repository.ClientRepository;
import com.ubots.winesale.repository.SaleRepository;

@Service
public class WineSaleServiceImp implements WineSaleService {

	private ClientRepository clientRepository;
	private SaleRepository saleRepository;

	@Autowired
	public WineSaleServiceImp(ClientRepository clientRepository, SaleRepository saleRepository) {
		this.clientRepository = clientRepository;
		this.saleRepository = saleRepository;
	}

	@Override
	public List<Client> listAllByTotalValue() {

		List<Client> clientList = clientRepository.findAll();
		List<Sale> saleList = saleRepository.findAll();

		List<Client> orderedClients = new ArrayList<Client>();

		saleList.stream().sorted(Comparator.comparingDouble(Sale::getValorTotal)).forEach(s1 -> {

			StringBuilder saleCpf = new StringBuilder(s1.getCliente());

			saleCpf.setCharAt(11, '-');

			Client newClient = clientList.stream().filter(c1 -> c1.getCpf().equals(saleCpf.toString())).findFirst()
					.orElse(null);

			if (newClient != null) {

				orderedClients.add(newClient);
			}
		});

		return orderedClients.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public Client getHighestSale() {

		List<Client> clientList = clientRepository.findAll();
		List<Sale> saleList = saleRepository.findAll();

		Sale highestSale = saleList.stream().sorted(Comparator.comparingDouble(Sale::getValorTotal)).findFirst()
				.orElse(null);

		StringBuilder saleCpf = new StringBuilder(highestSale.getCliente());

		saleCpf.setCharAt(11, '-');

		return clientList.stream().filter(c1 -> c1.getCpf().equals(saleCpf.toString())).findFirst().orElse(null);
	}

	@Override
	public List<Client> getLoyalestClients() {

		List<Client> clientList = clientRepository.findAll();
		List<Sale> saleList = saleRepository.findAll();

		Map<String, Integer> loyaltyMap = new HashMap<String, Integer>();
		List<Client> loyalest = new ArrayList<Client>();

		saleList.stream().forEach(s1 -> {

			if (loyaltyMap.containsKey(s1.getCliente())) {
				loyaltyMap.replace(s1.getCliente(), loyaltyMap.get(s1.getCliente()) + 1);
			} else {
				loyaltyMap.put(s1.getCliente(), 0);
			}
		});

		for (int i = 0; i < 3; i++) {

			int temp = 0;
			Client tempClient = null;

			for (Client client : clientList) {

				StringBuilder clientCpf = new StringBuilder(client.getCpf());

				clientCpf.setCharAt(11, '.');

				if (loyaltyMap.get(clientCpf.toString()) > temp) {
					temp = loyaltyMap.get(clientCpf.toString());
					tempClient = client;
				}
			}

			loyalest.add(tempClient);
			clientList.remove(tempClient);
		}
		return loyalest;
	}

	@Override
	public Wine getWineRecomendation(int id) {

		List<Sale> saleList = saleRepository.findAll();

		Optional<Client> result = clientRepository.findById(id);

		Client client = null;
		if (result.isPresent()) {
			client = result.get();
		} else {
			return null;
		}

		String clientCPF = client.getCpf();

		Sale newSale = saleList.stream().filter(sale -> !sale.getCliente().equals(clientCPF)).distinct().findFirst()
				.orElse(null);

		return newSale.getItens().stream().sorted().findAny().orElse(null);
	}

}
