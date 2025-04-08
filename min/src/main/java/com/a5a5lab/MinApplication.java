package com.a5a5lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class MinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinApplication.class, args);
	}

}
