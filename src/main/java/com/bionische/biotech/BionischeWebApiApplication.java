package com.bionische.biotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages={"com.bionische.biotech"})
@EnableJpaAuditing
public class BionischeWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BionischeWebApiApplication.class, args);
	}
}
