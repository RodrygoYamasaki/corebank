package br.com.fiap.corebank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.corebank.model.Account;
import br.com.fiap.corebank.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BankService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account deposit(Long accountId, Double amount) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account does not exist"));
        account.setOpeningBalance(account.getOpeningBalance().add(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdraw(Long accountId, Double amount) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account does not exist"));
        account.setOpeningBalance(account.getOpeningBalance().subtract(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }

    @Transactional
    public Account pix(Long originAccountId, Long destinationAccountId, Double amount) {
        Account origin = accountRepository
                .findById(originAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Origin account was not found"));
        Account destination = accountRepository
                .findById(destinationAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Destination account was not found"));

        origin.setOpeningBalance(origin.getOpeningBalance().subtract(BigDecimal.valueOf(amount)));
        destination.setOpeningBalance(destination.getOpeningBalance().add(BigDecimal.valueOf(amount)));

        accountRepository.save(destination);
        return accountRepository.save(origin);
    }
}
