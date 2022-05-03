package com.br.bankfinancing.requestDto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.models.enums.StatusClient;

public class ClientRequestDto {

	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Length(max = 60, message = "{campo.name.caracteres}")
	private String name;

	@Email
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private String email;

	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private StatusClient status;

	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{campo.data.invalido}")
	private Date dateCreation;

	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{campo.data.invalido}")
	private Date updateDate;

	public ClientRequestDto(ClientModel clientModel) {
		this.name = clientModel.getName();
		this.email = clientModel.getEmail();
		this.status = clientModel.getStatus();
		this.dateCreation = clientModel.getDateCreation();
		this.updateDate = clientModel.getUpdateDate();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusClient getStatus() {
		return status;
	}

	public void setStatus(StatusClient status) {
		this.status = status;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
