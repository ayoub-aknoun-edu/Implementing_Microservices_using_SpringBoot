package me.project.ebankaccountservice.service;

import me.project.ebankaccountservice.dtos.BankAccountRequestDTO;
import me.project.ebankaccountservice.dtos.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
