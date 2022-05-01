package com.br.bankfinancing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.repositories.ClientRepository;
import com.br.bankfinancing.requestDto.ClientRequestDto;
import com.br.bankfinancing.services.exceptions.ConflictDeDadosException;
import com.br.bankfinancing.services.exceptions.ObjetoNaoEncontradoException;

import br.com.kleryton.bankingsystem.models.AccountModel;

public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Transactional
	// Create client
	public ClientModel create(ClientRequestDto clienteRequestDto) {
		ClientModel clientModel = convertDtoToModel(clienteRequestDto);
		try {
			clientRepository.save(clientModel);
			// TODO implementar exception
		} catch (DataIntegrityViolationException e) {
			throw new ConflictDeDadosException("");
		}
		return clientModel;
	}

	public List<ClientModel> findAll() {
		// Verifica se existe clientes no banco, caso contrario retorna exception
		if (clientRepository.findAll().isEmpty()) {
			throw new ObjetoNaoEncontradoException("Clientes not found!");
		}
		// Salva clientes existentes no banco de dados em uma lista de clientes
		List<ClientModel> clientModelsList = new ArrayList<>();
		for (ClientModel clientModel : clientRepository.findAll()) {
			clientModelsList.add(clientModel);
		}
		return clientModelsList;
	}

	// Read One by Id
	@Transactional
	public Optional<ClientModel> findById(Long id) {

		// Verifica se a account existe no banco
		Optional<ClientModel> accountOptional = clientRepository.findById(id);
		accountOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("client not found."));

		return clientRepository.findById(id);
	}

	// Coverte um request DTO em client
	private ClientModel convertDtoToModel(ClientRequestDto clienteRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
