package bank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bank.entities.Account;
import bank.service.AccountService;

@RestController
public class AccountController  {

	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
	}
	
	@PostMapping("/api/account/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
//	    System.out.println("Received Account: " + account);
		return accountService.createAccount(account);		
	}
	
	@GetMapping("/api/account/getAll")
	public List<Account> getAllAccount(){
		return accountService.getAllAccount();
	}
	
	@PutMapping("/api/account/{accountId}")
	public Account updateAccount(@PathVariable int accountId,@RequestBody Account account) {
		
		return accountService.updateAccount(accountId, account);
	}
	
	@RequestMapping(value="/api/account/{accountId}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable int accountId) {
		return accountService.getAccount(accountId);
	}
	
	@DeleteMapping("/api/account/{accountId}")
	public Account deleteAccount(@PathVariable int accountId) {
		return accountService.deleteAccount(accountId);
	}
//	
	/**
	 * GetMapping,PostMapping,PutMapping,DeleteMapping.PutMApping are shortest way of http methods crestaion 
	 * RequestMapping(value="\api\account",method=RequestMethod.GET)  -> @GetMapping
	 * RequestMapping(value="\api\account\{accountId}",method=RequestMethod.GET) -> @GetMapping
	 * RequestMapping(value="\api\account",method=RequestMethod.POST) -> @PostMapping
	 * RequestMapping(value="\api\account\{accountId}",method=RequestMethod.PUT) -> @PutMapping
	 * RequestMapping(value="\api\account\{accountId},method=RequestMethod.DELETE) -> @DeleteMapping
	 */
}
