package com.bank.sbi.controller;

import com.bank.sbi.domain.Account;
import com.bank.sbi.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/account")
public class AccountController {
    private final IAccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Account addData(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
}
