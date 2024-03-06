package com.bank.sbi.service;

import com.bank.sbi.domain.Account;

import java.util.List;

public interface IAccountService {
Account createAccount(Account account);
Account updateAccount(long accountNumber,Account account);
Account deleteAccount(long accountNumber);
Account getAccount(long accountNumber);
Account getAccountBySlNo(int slNo);
Account getAccountByEmail(String email);
List<Account> getAccounts();
}
