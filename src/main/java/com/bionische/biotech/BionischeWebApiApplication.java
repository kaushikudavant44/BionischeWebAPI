package com.bionische.biotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.bionische.biotech"})
@EnableJpaAuditing
@EnableScheduling
public class BionischeWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BionischeWebApiApplication.class, args);
	}
}
