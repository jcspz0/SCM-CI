package com.stardan.personservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stardan.personservice.repository.PersonRepository;

@SpringBootApplication
//@EnableJpaRepositories("com.stardan.personservice.repository")
@EnableJpaRepositories(basePackageClasses= {PersonRepository.class})
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PersonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}
}
