package com.github.amorixa.progressdocument.config;

import com.github.amorixa.progressdocument.handler.DocumentWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

	private final DocumentWebSocketHandler documentWebSocketHandler;

	public WebSocketConfig(DocumentWebSocketHandler documentWebSocketHandler) {
		this.documentWebSocketHandler = documentWebSocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(documentWebSocketHandler, "/progress").setAllowedOrigins("*");
	}
}
