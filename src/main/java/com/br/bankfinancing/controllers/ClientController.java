package com.br.bankfinancing.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.requestDto.ClientRequestDto;
import com.br.bankfinancing.services.ClientService;

import br.com.kleryton.bankingsystem.models.AccountModel;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/v1/bankin-financing")
//Otimiza o acesso a API
@CrossOrigin(origins="*")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	// SaveClient
	@PostMapping("/client/add")
	public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientRequestDto clienteRequestDto) {
		ClientModel clientModel = clientService.create(clienteRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientModel);
	}
	
	// Read All
		@GetMapping("/client/all")
		public ResponseEntity<List<ClientModel>> getAllAccountModel() {
			return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
		}
	

}
