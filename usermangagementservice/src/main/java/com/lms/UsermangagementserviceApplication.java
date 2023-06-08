package com.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class UsermangagementserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermangagementserviceApplication.class, args);
	}

}
