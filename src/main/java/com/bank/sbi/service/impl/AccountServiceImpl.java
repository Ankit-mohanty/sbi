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
    public Account updateAccount(long accountNumber, Account account) {
        return null;
    }

    @Override
    public Account deleteAccount(long accountNumber) {
        return null;
    }

    @Override
    public Account getAccount(long accountNumber) {
        return null;
    }

    @Override
    public Account getAccountBySlNo(int slNo) {
        return null;
    }

    @Override
    public Account getAccountByEmail(String email) {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }
}
