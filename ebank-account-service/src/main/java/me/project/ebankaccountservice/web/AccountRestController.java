package me.project.ebankaccountservice.web;

import me.project.ebankaccountservice.dtos.BankAccountRequestDTO;
import me.project.ebankaccountservice.dtos.BankAccountResponseDTO;
import me.project.ebankaccountservice.entities.BankAccount;
import me.project.ebankaccountservice.repositories.BankAccountRepository;
import me.project.ebankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }


    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount account){
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
        if(account.getBalance()!=null) bankAccount.setBalance(account.getBalance());
        if (account.getCurrency()!=null) bankAccount.setCurrency(account.getCurrency());
        if (account.getType()!=null) bankAccount.setType(account.getType());
        if (account.getCreatedAt()!=null) bankAccount.setCreatedAt(account.getCreatedAt());
        return bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }



}
