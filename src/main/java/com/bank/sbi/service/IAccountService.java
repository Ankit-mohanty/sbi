package com.bank.sbi.service;

import com.bank.sbi.domain.Account;

import java.util.List;

public interface IAccountService {
Account createAccount(Account account);

void deposit(long accountNo, double balance);
void withdraw(long accountNo, double balance);
void transfer(long sender,long receiver,double balance);
Account updateAccount(long accountNumber,Account account);
Account deleteAccount(long accountNumber);
Account getAccount(long accountNumber);
Account getAccountBySlNo(int slNo);
Account getAccountByEmail(String email);
List<Account> getAccounts();
Account getAccountbyEmailAndPassword(String email,String password);
}
