package com.eonetworks;

import com.eonetworks.SilniaDatabase.SilniaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SilniaRepository.class)
public class SilniaApplication {


	public static void main(String[] args) {
		SpringApplication.run(SilniaApplication.class, args);
	}
}
