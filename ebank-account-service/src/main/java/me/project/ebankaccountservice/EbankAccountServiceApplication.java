package me.project.ebankaccountservice;

import me.project.ebankaccountservice.entities.BankAccount;
import me.project.ebankaccountservice.entities.Customer;
import me.project.ebankaccountservice.enums.AccountType;
import me.project.ebankaccountservice.repositories.BankAccountRepository;
import me.project.ebankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {

			Stream.of("Mohamed","Yassine","Hanae","Imane").forEach(c->{
				Customer customer = Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});

			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.balance(10000+Math.random()*10000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});
		};
	}

}
