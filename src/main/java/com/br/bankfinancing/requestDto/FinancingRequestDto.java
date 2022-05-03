package com.br.bankfinancing.requestDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.br.bankfinancing.models.FinancingModel;
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

	public FinancingRequestDto(FinancingModel financingModel) {
		super();
		this.valorTotal = financingModel.getValorTotal();
		this.parcelas = financingModel.getParcelas();
		this.renda = financingModel.getRenda();
		this.meses = financingModel.getMeses();
		this.typeFinancing = financingModel.getTypeFinancing();
		this.statusFinancing = financingModel.getStatusFinancing();
		this.inputValueFinancing = financingModel.getInputValueFinancing();
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public TypeFinancing getTypeFinancing() {
		return typeFinancing;
	}

	public void setTypeFinancing(TypeFinancing typeFinancing) {
		this.typeFinancing = typeFinancing;
	}

	public StatusFinancing getStatusFinancing() {
		return statusFinancing;
	}

	public void setStatusFinancing(StatusFinancing statusFinancing) {
		this.statusFinancing = statusFinancing;
	}

	public double getInputValueFinancing() {
		return inputValueFinancing;
	}

	public void setInputValueFinancing(double inputValueFinancing) {
		this.inputValueFinancing = inputValueFinancing;
	}

}
