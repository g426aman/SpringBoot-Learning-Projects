package net.springboot.Banking_app.service.impl;

import net.springboot.Banking_app.Mapper.AccountMapper;
import net.springboot.Banking_app.dto.AccountDto;
import net.springboot.Banking_app.entity.Account;
import net.springboot.Banking_app.repository.AccountRepository;
import net.springboot.Banking_app.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

       Account account= accountRepository
               .findById(id)
               .orElseThrow(()->new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account= accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

        double total=account.getBalance()+amount;
        account.setBalance(total);

       Account savedAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount) ;
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account= accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
       return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

        accountRepository.deleteById(id);
    }


}
