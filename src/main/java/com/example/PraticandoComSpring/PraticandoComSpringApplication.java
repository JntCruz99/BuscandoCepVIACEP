package com.example.PraticandoComSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

//http://localhost:8080/swagger-ui/index.html
@EnableFeignClients
@SpringBootApplication
public class PraticandoComSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticandoComSpringApplication.class, args);
	}

}
