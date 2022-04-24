package com.br.bankfinancing.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	

}
