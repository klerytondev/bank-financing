package com.br.bankfinancing.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.repositories.ClientRepository;
import com.br.bankfinancing.requestDto.ClientRequestDto;
import com.br.bankfinancing.services.exceptions.ConflictDeDadosException;

public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Transactional
	// Create client
	public ClientModel create(ClientRequestDto clienteRequestDto) {
		ClientModel clientModel = convertDtoToModel(clienteRequestDto);
		try {
			clientRepository.save(clientModel);
			//TODO implementar exception
		} catch (DataIntegrityViolationException e) {
			throw new ConflictDeDadosException("");
		}
		return clientModel;
	}

	// Coverte um request DTO em client
	private ClientModel convertDtoToModel(ClientRequestDto clienteRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
