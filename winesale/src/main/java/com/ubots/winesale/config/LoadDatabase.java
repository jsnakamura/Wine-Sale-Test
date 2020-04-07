package com.ubots.winesale.config;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase()
			throws IOException, InterruptedException, URISyntaxException {
		
		return args -> {
		};
	}
}
