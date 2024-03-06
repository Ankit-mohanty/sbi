package com.bank.sbi.domain;

import com.bank.sbi.domain.helper.Auditing;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
//@Table(name/ = "account_table")
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
    private String accountHolderName;
    @Column(unique = true, length = 50, nullable = false)
    private String accountEmail;
    @Column(nullable = false)
    private String accountPassword;
    @Column(nullable = false)
    private String contactNo;
    @Lob
    private String aboutCustomer;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;
//    @Embedded
//    private Auditing audting;
}
