package com.br.bankfinancing.responseDto;

import java.util.Date;
import java.util.Set;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.models.FinancingModel;
import com.br.bankfinancing.models.enums.StatusClient;

public class ClientResponseDto {

	private Long id;
	private String name;
	private String email;
	private StatusClient statusClient;
	private Date opdateData;
	private Set<FinancingModel> financingModels;

	public ClientResponseDto() {
	}

	public ClientResponseDto(ClientModel clientModel) {
		this.id = clientModel.getId();
		this.name = clientModel.getName();
		this.email = clientModel.getEmail();
		this.statusClient = clientModel.getStatus();
		this.opdateData = clientModel.getUpdateDate();
		this.financingModels = clientModel.getFinancingModels();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public StatusClient getStatusClient() {
		return statusClient;
	}

	public Date getOpdateData() {
		return opdateData;
	}

	public Set<FinancingModel> getFinancingModels() {
		return financingModels;
	}

}
