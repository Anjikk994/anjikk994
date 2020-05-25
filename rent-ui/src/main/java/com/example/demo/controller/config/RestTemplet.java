package com.example.demo.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplet {
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
