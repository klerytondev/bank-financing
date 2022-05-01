package com.br.bankfinancing.requestDto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.br.bankfinancing.models.enums.StatusClient;

public class ClientRequestDto {
	
	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Length(max = 60, message = "{campo.name.caracteres}")
	private String name;
	
	@Email
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private String email;
	
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private StatusClient status;
	
	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{campo.data.invalido}")
	private Date dateCreation;
	
	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{campo.data.invalido}")
	private Date updateDate;

}
