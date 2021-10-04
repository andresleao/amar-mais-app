package com.acc.amar.mais.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acc.amar.mais.services.DBService;

@Configuration
@Profile("production")
public class ProductionConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instanciaDB() {
		
		if (ddl.equals("create")) {
			this.dbService.instanciaDB();	
		}
		
		return false;	
	}
}
