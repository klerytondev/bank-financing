package com.br.bankfinancing.services.exceptions;

public class ConflictDeDadosException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ConflictDeDadosException(String msg) {
		super(msg);
	}

	public ConflictDeDadosException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
