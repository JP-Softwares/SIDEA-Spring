package com.jp.SIDEA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SideaApplication {

	@Profile("prod")
	public static void main(String[] args) {
		SpringApplication.run(SideaApplication.class, args);
	}
}
