package com.bank.sbi.mapper;

import com.bank.sbi.constant.AccountType;
import com.bank.sbi.domain.Account;
import com.bank.sbi.domain.Credential;
import com.bank.sbi.dto.AccountRequestDTO;
import com.bank.sbi.dto.AccountresponseDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class AccountMapper {
    public static Account modelMapper(AccountRequestDTO dto) {
        Credential credential = new Credential();
        BeanUtils.copyProperties(dto, credential);

        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        account.setCredential(credential);
        return account;
    }

    public static AccountresponseDTO dtoMapper(Account account) {
        long accountNo = account.getAccountNo();
        String accountName = account.getAccountName();
        String contactNumber = account.getContactNo();
        String aboutCustomer = account.getAboutCustomer();
        double customerBalance = account.getAccountBalance();
        AccountType accountType = account.getAccountType();

        Credential credential = account.getCredential();
        String customerEmail = credential.getAccountEmail();

        return new AccountresponseDTO(
                accountNo,
                accountName,
                contactNumber,
                aboutCustomer,
                customerEmail,
                customerBalance,
                accountType
        );

    }
}

