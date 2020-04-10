package com.ubots.winesale.helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.ubots.winesale.entity.Client;
import com.ubots.winesale.entity.Sale;

public class DataHelper {

	private Gson gson = new Gson();

	private HttpClient httpClient = new HttpClient();

	public List<Client> getClientsFromJson() {

		String response;
		try {
			response = httpClient.get("http://www.mocky.io/v2/598b16291100004705515ec5");
			return Arrays.asList(gson.fromJson(response, Client[].class));

		} catch (IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Sale> getSalesFromJson() {

		String response;

		try {
			response = httpClient.get("http://www.mocky.io/v2/598b16861100004905515ec7");
			return Arrays.asList(gson.fromJson(response, Sale[].class));

		} catch (IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
