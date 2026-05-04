package com.Lucena.Catalogo_Jogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CatalogoJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoJogosApplication.class, args);
	}

}
