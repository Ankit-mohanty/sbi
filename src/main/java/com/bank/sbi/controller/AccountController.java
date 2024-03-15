package com.bank.sbi.controller;

import com.bank.sbi.domain.Account;
import com.bank.sbi.domain.Credential;
import com.bank.sbi.dto.AccountRequestDTO;
import com.bank.sbi.dto.AccountresponseDTO;
import com.bank.sbi.mapper.AccountMapper;
import com.bank.sbi.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create Account")
    public AccountresponseDTO addData( @Valid @RequestBody AccountRequestDTO dto ) {
        Account account = AccountMapper.modelMapper( dto );
        Account result = accountService.createAccount( account );
        return AccountMapper.dtoMapper( result );
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Account LogIn")
    public AccountresponseDTO login( @RequestBody Credential cre ) {
        Account result = accountService.getAccountbyEmailAndPassword( cre.getAccountEmail(),
                cre.getAccountPassword() );
        return AccountMapper.dtoMapper( result );
    }

    @PutMapping("/update")
    @Operation(summary = "Account update ")
    public AccountresponseDTO update( @PathVariable long accountNo,
                                      @RequestBody AccountRequestDTO account ) {
        Account result = AccountMapper.modelMapper( account );
        Account update = accountService.updateAccount( accountNo, result );
        return AccountMapper.dtoMapper( update );
    }

    @PatchMapping("/deposit/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deposit Money In Account")
    public void addMoney( @RequestHeader long accountNo, @PathVariable double balance ) {
        accountService.deposit( accountNo, balance );
    }

    @PatchMapping("/withdraw/{balance}")
    @Operation(summary = "Withdraw Money Form The Account")
    public void withdrawMoney( @RequestHeader long accountNo, @PathVariable double balance ) {
        accountService.withdraw( accountNo, balance );
    }

    @PatchMapping("/transfer/{receiver}/balance/{balance}")
    @Operation(summary = "Transfer Money")
    public void transferMoney( @RequestHeader long sender, @PathVariable long receiver,
                               @PathVariable double balance ) {
        accountService.transfer( sender, receiver, balance );
    }

    @DeleteMapping("/delete/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete Account")
    public AccountresponseDTO delete( @PathVariable("accountNumber") long accountNo ) {
        Account result = accountService.deleteAccount( accountNo );
        return AccountMapper.dtoMapper( result );
    }

    @GetMapping
    @Operation(summary = "Showing All Accounts With All Details")
    public List < AccountresponseDTO > allData() {
        List < Account > result = accountService.getAccounts();
        return result.stream().map( AccountMapper::dtoMapper ).toList();
    }

    @GetMapping("{slNo}")
    @Operation(summary = "Get Account By SlNo")
    public AccountresponseDTO getById( @PathVariable int slNo ) {
        Account result = accountService.getAccountBySlNo( slNo );
        return AccountMapper.dtoMapper( result );
    }

    @GetMapping("/email{email}")
    @Operation(summary = "Get Account By Email")
    public AccountresponseDTO byEmail( @PathVariable String email ) {
        Account result = accountService.getAccountByEmail( email );
        return AccountMapper.dtoMapper( result );
    }

    @GetMapping("/accountNumber/{accountNumber}")
    @Operation(summary = "Get Account By AccountNumber")
    public AccountresponseDTO byAccountNumber( @PathVariable long accountNumber ) {
        Account result = accountService.getAccount( accountNumber );
        return AccountMapper.dtoMapper( result );

    }

}
