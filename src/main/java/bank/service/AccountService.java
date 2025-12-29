package bank.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Account> getAllAccount(){
		return accountRepo.findAll();
	}
	
	public Account updateAccount(int accountId,Account account) {
		
		Account accDetails = accountRepo.findById(accountId).orElse(null);
		
		if(accDetails!= null) {
			accDetails.setAccountType(account.getAccountType());
			accDetails.setBalance(account.getBalance());
			return accountRepo.save(accDetails);
		}
		
		return null;
	}
	
	public Account getAccount(int accountId) {
		
		Account accDetails = accountRepo.findById(accountId).orElse(null);
		
		if(accDetails!=null) {
			return accDetails;
		}
		
		return null;
	}
	
	public Account deleteAccount(int accountId) {
		
		Account accountDetails=accountRepo.findById(accountId).orElse(null);
		
		if(accountDetails!=null) {
		     accountRepo.delete(accountDetails);
		     return accountDetails;
		}
		return null;
	}

}
