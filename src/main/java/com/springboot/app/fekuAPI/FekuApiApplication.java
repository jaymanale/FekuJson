package com.springboot.app.fekuAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FekuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FekuApiApplication.class, args);
	}

}
