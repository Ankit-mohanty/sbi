package com.bank.sbi.domain;

import com.bank.sbi.constant.AccountType;
import com.bank.sbi.domain.helper.Auditing;
import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name="account_table")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Account extends Auditing{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountSlNo;
    @Column(unique = true, nullable = false)
    private long accountNo;
    @Column(name = "account_name", nullable = false)
    private String accountName;
    private double accountBalance;
    @Column(nullable = false)
    private String contactNo;
    @Lob
    private String aboutCustomer;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;
    @Embedded
    private Credential credential;
}
