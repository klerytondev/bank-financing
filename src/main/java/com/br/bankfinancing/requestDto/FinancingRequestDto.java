package com.br.bankfinancing.requestDto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.br.bankfinancing.models.enums.StatusFinancing;
import com.br.bankfinancing.models.enums.TypeFinancing;

public class FinancingRequestDto {
	
	@PositiveOrZero(message = "{campo.positiveorzero.postivo}")
	private double valorTotal;
	
	@NotEmpty(message = "{campo.parcelas.obrigatorio}")
	private int parcelas;
	
	@NotEmpty(message = "{campo.renda.obrigatorio}")
	private double renda;
	
	@NotEmpty(message = "{campo.meses.obrigatorio}")
	private int meses;
	
	private TypeFinancing typeFinancing;
	
	private StatusFinancing statusFinancing;
	
	@PositiveOrZero(message = "{campo.positiveorzero.postivo}")
	private double inputValueFinancing;

}
