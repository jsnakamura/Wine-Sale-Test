package com.ubots.winesale.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.winesale.entity.Client;
import com.ubots.winesale.service.WineSaleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class WineSaleRestController {
	
	private WineSaleService wineSaleService;

	@Autowired
	public WineSaleRestController(WineSaleService wineSaleService) {
		this.wineSaleService = wineSaleService;
	}
	
	@ApiOperation(value = "Get list of clients ordered by total value bought")
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> listClientsByTotalValue() {
		
		
		
		
		
		return null;
		
	}

}
