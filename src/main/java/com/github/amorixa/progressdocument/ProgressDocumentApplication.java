package com.github.amorixa.progressdocument;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class ProgressDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgressDocumentApplication.class, args);
	}

}
