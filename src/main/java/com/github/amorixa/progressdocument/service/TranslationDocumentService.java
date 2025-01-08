package com.github.amorixa.progressdocument.service;

import com.github.amorixa.progressdocument.repository.TranslationDocumentRepository;
import com.github.amorixa.progressdocument.vo.DocumentTranslation;
import com.github.amorixa.progressdocument.vo.ProgressType;
import com.github.amorixa.progressdocument.vo.StatusType;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.github.amorixa.progressdocument.vo.DocumentRequestConverter.calculateProgress;

@Service
public class TranslationDocumentService {
	private final TranslationDocumentRepository repository;
	private final DocumentService documentService;

	public TranslationDocumentService(TranslationDocumentRepository repository, DocumentService documentService) {
		this.repository = repository;
		this.documentService = documentService;
	}

	public DocumentTranslation saveDocument(DocumentTranslation document) throws Exception {
		try {
			document.setLastUpdated(LocalDateTime.now().toString());
			DocumentTranslation save = repository.save(document);
			documentService.updateDocumentProgress();
			return save;
		} catch (PropertyValueException e) {
			throw new Exception(e.getMessage() + e.getCause());
		}
	}


	public List<DocumentTranslation> getAllDocuments() {
		return repository.findAll();
	}



	public DocumentTranslation updateProgress(Long id, ProgressType progress) throws Exception {
		DocumentTranslation document = repository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));

		document.setProgress(calculateProgress(progress));
		// Atualiza o progresso e a data de atualização
		document.setType(progress);
		if(calculateProgress(progress) == 100){
			document.setStatus(StatusType.CONCLUIDO.getType());
		}
		document.setLastUpdated(LocalDateTime.now().toString());

		// Envia a atualização via WebSocket
		DocumentTranslation update = repository.save(document);
		documentService.updateDocumentProgress();

		return update;
	}

	public DocumentTranslation updateStatus(Long id, StatusType status) throws Exception {
		DocumentTranslation document = repository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));

		document.setStatus(status.getType());
		document.setLastUpdated(LocalDateTime.now().toString());


		// Envia a atualização via WebSocket
		DocumentTranslation update = repository.save(document);
		documentService.updateDocumentProgress();

		return update;
	}
}
