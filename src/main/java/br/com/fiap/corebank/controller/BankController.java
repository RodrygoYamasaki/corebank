package br.com.fiap.corebank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.corebank.model.Account;
import br.com.fiap.corebank.service.BankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bank")
@Slf4j
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/deposit")
    public Account deposit(@RequestBody Map<String, String> body) {
        Long accountId = Long.parseLong(body.get("accountId"));
        Double amount = Double.parseDouble(body.get("amount"));
        log.info("Received deposit request: accountId={}, amount={}", accountId, amount);
        Account updatedAccount = bankService.deposit(accountId, amount);
        log.info("Deposit processed: accountId={}, newBalance={}", accountId, updatedAccount.getOpeningBalance());
        return updatedAccount;
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody Map<String, String> body) {
        Long accountId = Long.parseLong(body.get("accountId"));
        Double amount = Double.parseDouble(body.get("amount"));
        log.info("Received withdraw request: accountId={}, amount={}", accountId, amount);
        Account updatedAccount = bankService.withdraw(accountId, amount);
        log.info("Withdraw processed: accountId={}, newBalance={}", accountId, updatedAccount.getOpeningBalance());
        return updatedAccount;
    }

    @PostMapping("/pix")
    public Account pix(@RequestBody Map<String, String> body) {
        Long originAccountId = Long.parseLong(body.get("originAccountId"));
        Long destinationAccountId = Long.parseLong(body.get("destinationAccountId"));
        Double amount = Double.parseDouble(body.get("amount"));
        log.info("Received pix request: originAccountId={}, destinationAccountId={}, amount={}", originAccountId, destinationAccountId, amount);
        Account updatedAccount = bankService.pix(originAccountId, destinationAccountId, amount);
        log.info("Pix processed: originAccountId={}, newBalance={}", originAccountId, updatedAccount.getOpeningBalance());
        return updatedAccount;
    }

}
