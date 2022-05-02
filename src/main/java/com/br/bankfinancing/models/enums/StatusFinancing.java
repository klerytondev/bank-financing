package com.br.bankfinancing.models.enums;

import javax.validation.constraints.Pattern;

public enum StatusFinancing {

	ABERTO("aberto"), FECHADO("fechado"), BLOQUEADO("bloqueado");

	// @regex validar os possiveis tipos de status
	@Pattern(regexp = "ABERTO|FECHADO|BLOQUEADO")
	private String status;

	private StatusFinancing(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
