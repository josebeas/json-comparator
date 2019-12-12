package com.jbeas.jsoncomparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jbeas.jsoncomparator")
@SpringBootApplication
public class JsonComparatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonComparatorApplication.class, args);
	}

}
