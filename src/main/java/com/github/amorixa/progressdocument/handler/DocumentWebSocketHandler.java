package com.github.amorixa.progressdocument.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.amorixa.progressdocument.repository.TranslationDocumentRepository;
import com.github.amorixa.progressdocument.vo.DocumentTranslation;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DocumentWebSocketHandler extends TextWebSocketHandler  {
	// Conjunto para armazenar todas as sessões WebSocket ativas
	private final TranslationDocumentRepository repository;
	private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

	public DocumentWebSocketHandler(TranslationDocumentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// Adiciona a nova sessão quando um cliente se conecta
		sessions.add(session);

		//Não é recomendado para uma empresa grande, USE REDIS
		sendMessageToAllClients();
		System.out.println("Nova conexão WebSocket estabelecida: " + session.getId());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// Não há necessidade de tratar mensagens recebidas, pois só enviaremos dados
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// Remove a sessão quando o cliente se desconectar
		sessions.remove(session);
		System.out.println("Conexão WebSocket fechada: " + session.getId());
	}



	public void sendMessageToAllClients() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonMessage = objectMapper.writeValueAsString(repository.findAll()); // Converte o objeto para JSON
			synchronized (sessions) {
				for (WebSocketSession session : sessions) {
					try {
						session.sendMessage(new TextMessage(jsonMessage)); // Envia o JSON para todos os clientes
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
