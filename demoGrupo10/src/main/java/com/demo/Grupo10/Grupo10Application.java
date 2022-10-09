package com.demo.Grupo10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.demo.Grupo10.Modelo"})
@SpringBootApplication
public class Grupo10Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo10Application.class, args);
	}

}
