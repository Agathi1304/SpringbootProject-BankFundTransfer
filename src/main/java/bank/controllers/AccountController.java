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

@RestController
public class AccountController  {

	@PostMapping("api/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		
	}
	
	@GetMapping("api/account")
	public List<Account> getAllAccount(){
		
	}
	
	@PutMapping("api/account/{account_id}")
	public Account updateAccount(@PathVariable int accountId,@RequestBody Account account) {
		
	}
	
	@RequestMapping(value="/api/account/{accountId}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable int accountId) {
		
	}
	
	@DeleteMapping("/api/account/{accountId}")
	public Account deleteAccount(@PathVariable int aaccountId) {
		
	}
	
	/**
	 * GetMapping,PostMapping,PutMapping,DeleteMapping.PutMApping are shortest way of http methods crestaion 
	 * RequestMapping(value="\api\account",method=RequestMethod.GET)  -> @GetMapping
	 * RequestMapping(value="\api\account\{accountId}",method=RequestMethod.GET) -> @GetMapping
	 * RequestMapping(value="\api\account",method=RequestMethod.POST) -> @PostMapping
	 * RequestMapping(value="\api\account\{accountId}",method=RequestMethod.PUT) -> @PutMapping
	 * RequestMapping(value="\api\account\{accountId},method=RequestMethod.DELETE) -> @DeleteMapping
	 */
}
