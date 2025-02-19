package com.schooltecher.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("Database connected successfully");
	}

	@GetMapping("/")
	public String hello() {
		return String.format("Hello and welcome to this API written with Java's Spring Boot framework! Navigate by accessing the endpoints below (prefix is '/api/v1'):\n\n" +
				"Unauthenticated:\n" +
				"'/auth/register'\n" +
				"'/auth/login'\n\n" +
				"Authenticated (will need to supply access token as 'Bearer '):\n");
	}
}
