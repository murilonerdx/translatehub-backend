package com.github.amorixa.progressdocument.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Permite todos os endpoints da API
						.allowedOrigins("http://localhost:5173") // Permite o frontend em localhost:3000
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
						.allowedHeaders("*") // Permite todos os cabeçalhos
						.allowCredentials(true); // Permite envio de cookies/autenticação
			}
		};
	}
}
