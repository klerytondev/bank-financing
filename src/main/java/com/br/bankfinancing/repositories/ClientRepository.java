package com.br.bankfinancing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.bankfinancing.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
	

}
