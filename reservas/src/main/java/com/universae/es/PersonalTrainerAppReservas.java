package com.universae.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = PersonalTrainerAppReservas.class)
public class PersonalTrainerAppReservas {

	public static void main(String[] args) {
		SpringApplication.run(PersonalTrainerAppReservas.class, args);
	}
	
}
