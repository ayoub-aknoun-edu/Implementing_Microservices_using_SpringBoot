package me.project.ebankaccountservice.entities;

import me.project.ebankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public Double getBalance();
    public AccountType getType();

}
