package com.github.amorixa.progressdocument.repository;

import com.github.amorixa.progressdocument.vo.DocumentTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationDocumentRepository extends JpaRepository<DocumentTranslation, Long> {
}
