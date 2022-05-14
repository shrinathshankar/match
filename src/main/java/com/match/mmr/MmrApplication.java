package com.match.mmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.match.mmr.model.entity")
public class MmrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmrApplication.class, args);
	}

}
