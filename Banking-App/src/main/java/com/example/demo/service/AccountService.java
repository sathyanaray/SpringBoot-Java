package com.example.demo.service;

import com.example.demo.Dto.AccountDto;
import com.example.demo.mapper.AccountMapper;

import java.util.List;

public interface AccountService {
    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id,double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
