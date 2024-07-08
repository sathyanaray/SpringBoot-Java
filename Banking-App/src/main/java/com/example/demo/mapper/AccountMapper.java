package com.example.demo.mapper;

import com.example.demo.Dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepo;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()

        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){

       AccountDto accountDto = new AccountDto( account.getId(),
        account.getAccountHolderName(),
        account.getBalance()
       );
        return accountDto;
    }
}
