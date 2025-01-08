package com.github.amorixa.progressdocument.controller;

import com.github.amorixa.progressdocument.service.TranslationDocumentService;
import com.github.amorixa.progressdocument.vo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:5173")
public class TranslationDocumentController {

	private final TranslationDocumentService service;

	public TranslationDocumentController(TranslationDocumentService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<DocumentTranslation> createDocument(@RequestBody DocumentRequest document) throws Exception {
		return ResponseEntity.ok(service.saveDocument(DocumentRequestConverter.toTranslationDocument(document)));
	}

	@GetMapping
	public ResponseEntity<List<DocumentTranslation>> getAllDocuments() {
		return ResponseEntity.ok(service.getAllDocuments());
	}

	@PutMapping("/{id}/progress")
	public ResponseEntity<DocumentTranslation> updateProgress(@PathVariable Long id, @RequestParam ProgressType progress) throws Exception {
		return ResponseEntity.ok(service.updateProgress(id, progress));
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<DocumentTranslation> updateStatus(@PathVariable Long id, @RequestParam StatusType status) throws Exception {
		return ResponseEntity.ok(service.updateStatus(id, status));
	}
}

