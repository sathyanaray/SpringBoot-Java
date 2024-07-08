package com.example.demo.service.Impl;

import com.example.demo.Dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepo;
import com.example.demo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account SavedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(SavedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
           Account account= accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepo.findById(id).orElseThrow(()
                ->new RuntimeException("Account not exist"));
        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account= accountRepo.findById(id).orElseThrow(()
                ->new RuntimeException("Account not exist"));
        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient balance");
        }
        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount =  accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepo.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepo.findById(id).orElseThrow(()
                ->new RuntimeException("Account not exist"));

        accountRepo.deleteById(id);
    }
}
