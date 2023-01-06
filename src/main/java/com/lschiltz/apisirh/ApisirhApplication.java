package com.lschiltz.apisirh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class ApisirhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisirhApplication.class, args);
	}

}
