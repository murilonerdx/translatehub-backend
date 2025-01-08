package com.github.amorixa.progressdocument.service;

import com.github.amorixa.progressdocument.handler.DocumentWebSocketHandler;
import com.github.amorixa.progressdocument.vo.DocumentTranslation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

	private final DocumentWebSocketHandler documentWebSocketHandler;

	public DocumentService(DocumentWebSocketHandler documentWebSocketHandler) {
		this.documentWebSocketHandler = documentWebSocketHandler;
	}

	public void updateDocumentProgress() throws Exception {
		// Enviar atualização via WebSocket em tempo real
		documentWebSocketHandler.sendMessageToAllClients();
	}
}
