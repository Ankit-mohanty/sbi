package com.bank.sbi.repository;

import com.bank.sbi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {



    Optional<Account> findByCredentialAccountEmailAndCredentialAccountPassword(String email, String Password);

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE account_email = ? ")
    Optional<Account> findByEmail(String email);

    Optional<Account> findByAccountNo(long accountNumber);

@Query("UPDATE Account a SET a.accountBalance= accountBalance + :balance WHERE a.accountNo= :accountNo")
@Modifying
@Transactional
    int addBalance(long accountNo,double balance);
@Query("UPDATE Account a SET a.accountBalance = accountBalance - :balance WHERE a.accountNo = :accountNo")
@Modifying
@Transactional
int deductBalance(long accountNo,double balance);
boolean existsByAccountNo(long accountNo);
}
