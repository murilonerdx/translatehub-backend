package com.github.amorixa.progressdocument.vo;

public class DocumentRequest {
	private String title;
	private String sourceLanguage;
	private String targetLanguage;
	private StatusType status;
	private String translator;
	private ProgressType progress;



	public DocumentRequest(String title, String sourceLanguage, String targetLanguage, StatusType status, String translator, ProgressType progress) {
		this.title = title;
		this.sourceLanguage = sourceLanguage;
		this.targetLanguage = targetLanguage;
		this.status = status;
		this.progress = progress;
		this.translator = translator;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public ProgressType getProgress() {
		return progress;
	}

	public void setProgress(ProgressType progress) {
		this.progress = progress;
	}


	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}
}
