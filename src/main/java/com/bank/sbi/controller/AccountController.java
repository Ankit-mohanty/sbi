package com.bank.sbi.controller;

import com.bank.sbi.domain.Account;
import com.bank.sbi.dto.AccountRequestDTO;
import com.bank.sbi.dto.AccountresponseDTO;
import com.bank.sbi.mapper.AccountMapper;
import com.bank.sbi.service.IAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/account")
public class AccountController {
    private final IAccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountresponseDTO addData(@Valid @RequestBody AccountRequestDTO dto) {
        Account account = AccountMapper.modelMapper(dto);
        Account result = accountService.createAccount(account);
        return AccountMapper.dtoMapper(result);
    }

    @PatchMapping("/deposit/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addMoney(@RequestHeader long accountNo, @PathVariable double balance) {
        accountService.deposit(accountNo, balance);
    }

    @PatchMapping("/withdraw/{balance}")
    public void withdrawMoney(@RequestHeader long accountNo, @PathVariable double balance) {
        accountService.withdraw(accountNo, balance);
    }

    @DeleteMapping("/delete/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public AccountresponseDTO delete(@PathVariable("accountNumber") long accountNo) {
        Account result = accountService.deleteAccount(accountNo);
        return AccountMapper.dtoMapper(result);
    }


    @GetMapping
    public List<AccountresponseDTO> allData() {
        List<Account> result = accountService.getAccounts();
        return result.stream().map(AccountMapper::dtoMapper).toList();
    }

    @GetMapping("{slNo}")
    public AccountresponseDTO getById(@PathVariable int slNo) {
        Account result = accountService.getAccountBySlNo(slNo);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping("/email{email}")
    public AccountresponseDTO byEmail(@PathVariable String email) {
        Account result = accountService.getAccountByEmail(email);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public AccountresponseDTO byAccountNuber(@PathVariable long accountNumber) {
        Account result = accountService.getAccount(accountNumber);
        return AccountMapper.dtoMapper(result);

    }

    @PostMapping("/login")
    public AccountresponseDTO login(@RequestBody String email, String password) {
        Account result = accountService.getAccountbyEmailAndPassword(email, password);
        return AccountMapper.dtoMapper(result);
    }
}
