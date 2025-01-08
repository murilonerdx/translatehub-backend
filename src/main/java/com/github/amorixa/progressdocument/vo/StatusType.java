package com.github.amorixa.progressdocument.vo;

public enum StatusType {
	AGUARDANDO("Aguardando"),
	PARADO("Parado"),
	EM_ANDAMENTO("Em andamento"),
	CONCLUIDO("Concluido")
	;

	final String type;
	StatusType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
