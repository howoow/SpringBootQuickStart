package com.example.biology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:application.yml")
public class BiologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiologyApplication.class, args);
	}

}
