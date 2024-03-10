package com.bank.sbi.dto;

import com.bank.sbi.constant.AccountType;

public record AccountRequestDTO (

        String accountName,
        String contactNo,
        String aboutCustomer,
        String accountEmail,
        String accountPassword,
        AccountType accountType
){
}
