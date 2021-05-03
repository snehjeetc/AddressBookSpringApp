package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Slf4j
public class AddressBookSpringAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AddressBookSpringAppApplication.class, args);
		log.info("profile: {}", context.getEnvironment().getProperty("profile"));
	}

}
