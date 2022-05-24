package com.br.bankfinancing.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.requestDto.ClientRequestDto;
import com.br.bankfinancing.responseDto.ClientResponseDto;
import com.br.bankfinancing.services.ClientService;

@RestController
@RequestMapping(value = "/v1/bankin-financing")
//Otimiza o acesso a API
@CrossOrigin(origins = "*")
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

	// Read One by Id
	@GetMapping("/client/{id}")
	public ResponseEntity<Object> getOneAccountModel(@PathVariable(value = "id") Long id) {
		Optional<ClientModel> ClientModelOptional = clientService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ClientRequestDto(ClientModelOptional.get()));
	}

	// Delete One by id
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Object> deleteAccountModel(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.delete(id));
	}
	
	// Update by id
		@PutMapping("/client/update")
		public ResponseEntity<ClientResponseDto> updateClientModel(@RequestParam("id") Long id,
				@RequestBody @Valid ClientRequestDto clientRequestDto) {
			ClientResponseDto clienteResponseDto = clientService.updateClient(id, clientRequestDto);
			return ResponseEntity.status(HttpStatus.OK).body(clienteResponseDto);
		}

}
