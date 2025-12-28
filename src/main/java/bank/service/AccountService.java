package bank.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bank.entities.Account;
import bank.repository.AccountRepository;
import bank.service.implementation.accountService;

@Service
public class AccountService implements accountService {
	
	//Construvtor injection
	private final AccountRepository accountRepo;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepo=accountRepository;
	}
	
	
	public ResponseEntity<Account> createAccount(Account account){
		Account createAccount =  accountRepo.save(account);
		return new ResponseEntity<Account>(createAccount,HttpStatus.CREATED);
	}

}
