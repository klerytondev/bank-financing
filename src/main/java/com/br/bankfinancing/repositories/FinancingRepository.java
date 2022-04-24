package com.br.bankfinancing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.bankfinancing.models.FinancingModel;

public interface FinancingRepository extends JpaRepository<FinancingModel, Long>{

}
