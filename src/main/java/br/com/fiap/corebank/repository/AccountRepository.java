package br.com.fiap.corebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.corebank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}