package com.github.amorixa.progressdocument.vo;

import java.time.LocalDateTime;

public class DocumentRequestConverter {
	public static DocumentTranslation toTranslationDocument(DocumentRequest request) {
		DocumentTranslation document = new DocumentTranslation();
		document.setTitle(request.getTitle());
		document.setSourceLanguage(request.getSourceLanguage());
		document.setTargetLanguage(request.getTargetLanguage());
		document.setStatus(request.getStatus().getType());
		document.setProgress(calculateProgress(request.getProgress()));
		document.setLastUpdated(LocalDateTime.now().toString());
		document.setTranslator(request.getTranslator());
		document.setType(request.getProgress());
		return document;
	}

	public static int calculateProgress(ProgressType progress) {
		switch (progress) {
			case INITIAL_DOCUMENTS:
				return 10; // Exemplo: 10% no início
			case DOCUMENT_UPDATE:
				return 50; // Exemplo: 50% durante a atualização
			case DOCUMENT_COMPLETE:
				return 100; // Exemplo: 100% ao finalizar a exclusão
			case REQUEST_DOCUMENTS:
				return 20; // Exemplo: 20% ao solicitar documentos
			default:
				return 0; // Caso o tipo não seja reconhecido, retorna 0%
		}
	}
}


