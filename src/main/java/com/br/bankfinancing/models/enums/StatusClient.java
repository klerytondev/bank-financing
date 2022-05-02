package com.br.bankfinancing.models.enums;

import javax.validation.constraints.Pattern;

public enum StatusClient {

	ATIVO("ativo"), INATIVO("intativo");

	// @regex validar os status do finaciamento
	@Pattern(regexp = "ATIVO|INATIVO")
	private String statusClient;

	private StatusClient(String statusClient) {
		this.statusClient = statusClient;
	}

	public String getStatusClient() {
		return statusClient;
	}

	public void setStatusClient(String statusClient) {
		this.statusClient = statusClient;
	}

}
