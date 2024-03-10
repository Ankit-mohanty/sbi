package com.bank.sbi.service.impl;

import com.bank.sbi.domain.Account;
import com.bank.sbi.repository.AccountRepository;
import com.bank.sbi.service.IAccountService;
import com.bank.sbi.utility.RandomAccountNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        account.setAccountNo(RandomAccountNumber.generate());
        return accountRepository.save(account);
    }

    @Override
    public void deposit(long accountNo, double balance) {
        accountRepository.addBalance(accountNo, balance);
    }

    @Override
    public void withdraw(long accountNo, double balance) {
        accountRepository.deductBalance(accountNo, balance);
    }

    @Override
    public Account updateAccount(long accountNumber, Account account) {
        return null;
    }

    @Override
    public Account deleteAccount(long accountNumber) {
        Account account=getAccount(accountNumber);
        accountRepository.delete(account);
        return account;
    }

    @Override
    public Account getAccount(long accountNumber) {
        return accountRepository.findByAccountNo(accountNumber).orElseThrow();
    }

    @Override
    public Account getAccountBySlNo(int slNo) {
        return accountRepository.findById(slNo).orElseThrow();
    }

    @Override
    public Account getAccountByEmail(String email) {
//        return accountRepository.findByCredentialAccountEmail(email).orElseThrow();
        return accountRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountbyEmailAndPassword(String email, String password) {
        return accountRepository
                .findByCredentialAccountEmailAndCredentialAccountPassword(email, password)
                .orElseThrow();
    }
}
