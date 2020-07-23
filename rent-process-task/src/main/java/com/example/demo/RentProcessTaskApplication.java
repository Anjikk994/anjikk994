package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class RentProcessTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentProcessTaskApplication.class, args);
	}

}
