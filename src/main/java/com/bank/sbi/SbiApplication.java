package com.bank.sbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditingImpl")
public class SbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbiApplication.class, args);
	}

}
