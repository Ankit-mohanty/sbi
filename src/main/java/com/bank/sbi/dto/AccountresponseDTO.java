package com.bank.sbi.dto;

import com.bank.sbi.constant.AccountType;

public record AccountresponseDTO(
        long accountNo,
        String accountName,
        String contactNo,
        String aboutCustomer,
        String accountEmail,
        double accountBalance,
        AccountType accountType
) {
}
