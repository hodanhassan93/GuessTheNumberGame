package com.teamseven.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.teamseven")
public class GuessTheNumberRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessTheNumberRestServiceApplication.class, args);
	}

}
