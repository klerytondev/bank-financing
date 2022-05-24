package com.br.bankfinancing.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.br.bankfinancing.models.ClientModel;
import com.br.bankfinancing.repositories.ClientRepository;
import com.br.bankfinancing.requestDto.ClientRequestDto;
import com.br.bankfinancing.responseDto.ClientResponseDto;
import com.br.bankfinancing.services.exceptions.ConflictDeDadosException;
import com.br.bankfinancing.services.exceptions.IntegridadeDeDadosException;
import com.br.bankfinancing.services.exceptions.ObjetoNaoEncontradoException;

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

	// Delete by id
	@Transactional
	public String delete(Long id) {

		Optional<ClientModel> clientModelOptional = clientRepository.findById(id);

		// Verifica se cliente existe
		if (!clientModelOptional.isPresent()) {
			throw new ObjetoNaoEncontradoException("Client not found.");
		}
		// Só é possivel excluir um cliente se não existir nenhuma
		// financiamentoassociado ao cliente
		// Verifica se existe uma financiamento associado a uma account
		else if (!(clientModelOptional.get().getFinancingModels() == null
				|| clientModelOptional.get().getFinancingModels().isEmpty())) {
			throw new IntegridadeDeDadosException("The client has financing. Unable to delete!");
		}

		clientRepository.deleteById(id);
		return "Client deleted successfully.";
	}

	// Update by id
	@Transactional
	public ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto) {

		// Busca no banco de dados se existe cliente com o id passado
		Optional<ClientModel> clienteMpdelOptional = clientRepository.findById(id);
		clienteMpdelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Client not found."));

		// Atualiza os campos do cliente existentes

		clienteMpdelOptional.get().setName(clientRequestDto.getName());
		clienteMpdelOptional.get().setEmail(clientRequestDto.getEmail());
		clienteMpdelOptional.get().setStatus(clientRequestDto.getStatus());
		clienteMpdelOptional.get().setUpdateDate(LocalDateTime.now());

		// Verifica se accountCode ou RegisteId já está em uso no banco
		try {
			clientRepository.save(clienteMpdelOptional.get());
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Email is already in use!");
		}
		ClientModel clientModel = clienteMpdelOptional.get();

		ClientResponseDto clienteResponseDto = convertDtoToModel(clientModel);

		return clienteResponseDto;

	}

	// Coverte um request DTO em client
	private ClientModel convertDtoToModel(ClientRequestDto clienteRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	// Coverte um model em client
	private ClientResponseDto convertDtoToModel(ClientModel clientModel) {
		ClientResponseDto clientResponseDto = new ClientResponseDto(clientModel);
		return clientResponseDto;
	}

}
