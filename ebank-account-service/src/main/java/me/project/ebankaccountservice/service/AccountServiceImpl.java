package me.project.ebankaccountservice.service;

import me.project.ebankaccountservice.dtos.BankAccountRequestDTO;
import me.project.ebankaccountservice.dtos.BankAccountResponseDTO;
import me.project.ebankaccountservice.entities.BankAccount;
import me.project.ebankaccountservice.mappers.AccountMapper;
import me.project.ebankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
      return accountMapper.fromBankAccount(bankAccountRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        bankAccount.setBalance(bankAccountDTO.getBalance());
        bankAccount.setCurrency(bankAccountDTO.getCurrency());
        bankAccount.setType(bankAccountDTO.getType());
        return accountMapper.fromBankAccount(bankAccountRepository.save(bankAccount));
    }

}
