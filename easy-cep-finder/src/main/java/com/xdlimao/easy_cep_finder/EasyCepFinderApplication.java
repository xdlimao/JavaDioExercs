package com.xdlimao.easy_cep_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EasyCepFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyCepFinderApplication.class, args);
	}

}
