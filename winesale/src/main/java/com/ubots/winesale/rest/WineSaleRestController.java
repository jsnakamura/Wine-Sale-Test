package com.ubots.winesale.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Wine;
import com.ubots.winesale.exception.ListNotFoundException;
import com.ubots.winesale.service.WineSaleService;

@RestController
@RequestMapping("/")
public class WineSaleRestController {

	private WineSaleService wineSaleService;

	@Autowired
	public WineSaleRestController(WineSaleService wineSaleService) {
		this.wineSaleService = wineSaleService;
	}

	@GetMapping("/clients")
	public ResponseEntity<List<Client>> listClientsByTotalValue() {

		List<Client> clientList = wineSaleService.listAllByTotalValue();

		if (!clientList.isEmpty()) {
			return new ResponseEntity<List<Client>>(clientList, HttpStatus.OK);
		} else {
			throw new ListNotFoundException("List is empty.");
		}
	}

	@GetMapping("/high")
	public ResponseEntity<Client> getClientHighestSale() {

		Client client = wineSaleService.getHighestSale();

		if (client != null) {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			throw new ListNotFoundException("No clients.");
		}
	}

	@GetMapping("/loyalest")
	public ResponseEntity<List<Client>> listLoyalestClients() {

		List<Client> loyalestClients = wineSaleService.getLoyalestClients();

		if (!loyalestClients.isEmpty()) {
			return new ResponseEntity<List<Client>>(loyalestClients, HttpStatus.OK);
		} else {
			throw new ListNotFoundException("List is empty.");
		}
	}

	@GetMapping("/recomendation/{id}")
	public ResponseEntity<Wine> getWineRecomendation(@PathVariable int id) {

		Wine recomendation = wineSaleService.getWineRecomendation(id);

		if (recomendation != null) {
			return new ResponseEntity<Wine>(recomendation, HttpStatus.OK);
		} else {
			throw new ListNotFoundException("No recomendation.");
		}
	}
}
