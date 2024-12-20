package com.stagwell.stagwellapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StagwellappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StagwellappApplication.class, args);
	}

}
