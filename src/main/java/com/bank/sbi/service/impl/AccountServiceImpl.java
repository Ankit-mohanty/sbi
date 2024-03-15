package com.bank.sbi.service.impl;

import com.bank.sbi.domain.Account;
import com.bank.sbi.repository.AccountRepository;
import com.bank.sbi.service.IAccountService;
import com.bank.sbi.utility.RandomAccountNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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
    @Transactional
    @Override
    public void transfer(long sender, long receiver, double balance) {

        boolean receiverAccount = accountRepository.existsByAccountNo(receiver);
        if (!receiverAccount) {
            throw new RuntimeException("No fund");
        }
        Account senderAccount = getAccount(sender);
        double senderBalance = senderAccount.getAccountBalance();
        if (senderBalance < balance) {
            throw new RuntimeException("Insufficient Fund");
        }
        accountRepository.addBalance(sender, balance);
        accountRepository.addBalance(receiver, balance);

    }

    @Override
    public Account updateAccount(long accountNumber, Account account) {
        Account account1 = getAccount(accountNumber);

        account1.setAccountName(account1.getAccountName());
        account1.setAboutCustomer(account1.getAboutCustomer());
        account1.setAccountType(account1.getAccountType());
        account1.setContactNo(account1.getContactNo());

        accountRepository.save(account1);
        return account1;

    }

    @Override
    public Account deleteAccount(long accountNumber) {
        Account account = getAccount(accountNumber);
        accountRepository.delete(account);
        return account;
    }

    @Override
    public Account getAccount(long accountNumber) {
        return accountRepository.findByAccountNo(accountNumber).orElseThrow(
                () -> new NoSuchElementException("No account available in this AccountNo")
        );
    }

    @Override
    public Account getAccountBySlNo(int slNo) {
        return accountRepository.findById(slNo).orElseThrow();
    }

    @Override
    public Account getAccountByEmail(String email) {
//        return accountRepository.findByCredentialAccountEmail(email).orElseThrow();
        return accountRepository.findByEmail(email).orElseThrow(
                () -> new NoSuchElementException("No Account available in this Email")
        );
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountbyEmailAndPassword(String email, String password) {
        return accountRepository
                .findByCredentialAccountEmailAndCredentialAccountPassword(email, password)
                .orElseThrow(
                        () -> new NoSuchElementException("Account not found for the provided credentials")
                );
    }
}
