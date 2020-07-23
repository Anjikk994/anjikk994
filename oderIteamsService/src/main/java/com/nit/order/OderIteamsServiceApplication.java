package com.nit.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OderIteamsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OderIteamsServiceApplication.class, args);
	}

}
