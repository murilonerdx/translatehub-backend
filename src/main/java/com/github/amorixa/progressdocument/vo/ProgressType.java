package com.github.amorixa.progressdocument.vo;

public enum ProgressType {
	REQUEST_DOCUMENTS("documents:request"),
	INITIAL_DOCUMENTS("documents:initial"),
	DOCUMENT_UPDATE("document:update"),
	DOCUMENT_COMPLETE("document:complete"),
	;

	final String type;
	ProgressType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
