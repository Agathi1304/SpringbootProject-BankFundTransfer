package bank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bank.entities.Account;
import bank.service.AccountService;

@RestController
public class AccountController  {

	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
	}
	
	@PostMapping("/api/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
	    System.out.println("Received Account: " + account);
		return accountService.createAccount(account);		
	}
	
//	@GetMapping("api/account")
//	public List<Account> getAllAccount(){
//		
//	}
//	
//	@PutMapping("api/account/{account_id}")
//	public Account updateAccount(@PathVariable int accountId,@RequestBody Account account) {
//		
//	}
//	
//	@RequestMapping(value="/api/account/{accountId}", method = RequestMethod.GET)
//	public Account getAccount(@PathVariable int accountId) {
//		
//	}
//	
//	@DeleteMapping("/api/account/{accountId}")
//	public Account deleteAccount(@PathVariable int aaccountId) {
//		
//	}
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
