package br.com.fiap.corebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.corebank.model.Account;
import br.com.fiap.corebank.model.AccountStatusType;
import br.com.fiap.corebank.repository.AccountRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("{id}")
    public Account findAccountById(@PathVariable Long id) {
        log.info("Searching for account record with ID: " + id);
        return getAccountById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody @Valid Account account) {
        log.info("Registering account: " + account);
        account.setStatus(AccountStatusType.ACTIVE);
        return accountRepository.save(account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Closing account with ID: " + id);
        Account account = getAccountById(id);
        account.setStatus(AccountStatusType.INACTIVE);
        accountRepository.save(account);
    }

    private Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No account found with the ID: " + id)
                );
    }
}