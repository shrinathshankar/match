package com.match.mmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class MmrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmrApplication.class, args);
	}

}
