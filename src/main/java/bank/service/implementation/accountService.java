package bank.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import bank.entities.Account;

public interface accountService {

	ResponseEntity<Account> createAccount(Account account);
//	List<Account> getAllAccount ();
//	Account updateAccount(int accountId,Account account);
//	Account getAccount(int accountId);
//	Account deleteAccount(int accountId);
}
