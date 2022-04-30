package com.br.bankfinancing.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.bankfinancing.models.enums.StatusFinancing;
import com.br.bankfinancing.models.enums.TypeFinancing;

@Entity
@Table(name = "TB_FINANCING")
public class FinancingModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private double valorTotal;
	@Column(nullable = false)
	private int parcelas;
	@Column(nullable = false)
	private double renda;
	@Column(nullable = false)
	private int meses;
	@Column(nullable = false)
	private TypeFinancing typeFinancing;
	@Column(nullable = false)
	private StatusFinancing statusFinancing;
	@Column(nullable = false)
	private double inputValueFinancing;
	
	public FinancingModel(double valorTotal, int parcelas, double renda, int meses, TypeFinancing typeFinancing,
			StatusFinancing statusFinancing, double inputValueFinancing) {
		this.valorTotal = valorTotal;
		this.parcelas = parcelas;
		this.renda = renda;
		this.meses = meses;
		this.typeFinancing = typeFinancing;
		this.statusFinancing = statusFinancing;
		this.inputValueFinancing = inputValueFinancing;
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
