package com.oneToMany.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestApiOntToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiOntToManyApplication.class, args);
	}

}
