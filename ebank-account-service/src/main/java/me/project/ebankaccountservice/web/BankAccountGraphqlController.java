package me.project.ebankaccountservice.web;

import me.project.ebankaccountservice.dtos.BankAccountRequestDTO;
import me.project.ebankaccountservice.dtos.BankAccountResponseDTO;
import me.project.ebankaccountservice.entities.BankAccount;
import me.project.ebankaccountservice.entities.Customer;
import me.project.ebankaccountservice.repositories.BankAccountRepository;
import me.project.ebankaccountservice.repositories.CustomerRepository;
import me.project.ebankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository repository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;


    @QueryMapping()
    public List<BankAccount> accountsList(){
        return repository.findAll();
    }


    @QueryMapping("accountById")
    public BankAccount BankAccountById(@Argument String id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }


    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO apdateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        repository.deleteById(id);
    }
}
