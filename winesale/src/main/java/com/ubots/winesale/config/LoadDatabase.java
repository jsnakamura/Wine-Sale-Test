package com.ubots.winesale.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Sale;
import com.ubots.winesale.helper.DataHelper;
import com.ubots.winesale.repository.ClientRepository;
import com.ubots.winesale.repository.SaleRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(ClientRepository clientRepository, SaleRepository saleRepository)
			throws IOException, InterruptedException, URISyntaxException {

		DataHelper dataHelper = new DataHelper();

		List<Client> clients = dataHelper.getClientsFromJson();

		List<Sale> sales = dataHelper.getSalesFromJson();

		clients.stream().forEach(client -> log.info("Preloading " + clientRepository.save(client)));

		sales.stream().forEach(sale -> log.info("Preloading " + saleRepository.save(sale)));

		return args -> {
		};
	}
}
