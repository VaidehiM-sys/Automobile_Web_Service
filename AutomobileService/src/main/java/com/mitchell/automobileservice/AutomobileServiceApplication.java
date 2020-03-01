package com.mitchell.automobileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.mitchell.automobileservice.controller","com.mitchell.automobileservice.model","com.mitchell.automobileservice.service"})
@SpringBootApplication
public class AutomobileServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutomobileServiceApplication.class, args);
	}
}
