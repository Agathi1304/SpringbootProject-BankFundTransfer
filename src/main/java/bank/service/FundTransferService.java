package bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.entities.Account;
import bank.repository.AccountRepository;

@Service
public class FundTransferService {
	
	@Autowired
	AccountRepository accountrepo;

	public String fundTransfer(int fromAccountNumber, int toAccountNumber, double amount) {
		
		Account fromAcc = accountrepo.findByAccountNumber(fromAccountNumber);
		Account toAcc = accountrepo.findByAccountNumber(toAccountNumber);
		
		
		if(fromAcc==null || toAcc==null) 
			return "Either source or destination account not found."; 
		
		
		if(fromAcc.getBalance()<amount) {
			return "Insufficient balance";
		}
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		accountrepo.save(fromAcc);
		accountrepo.save(toAcc);
		
		return "Fund transfer successful. ₹" + amount + " transferred from Account " 
		+ fromAccountNumber + " to Account " + toAccountNumber + ".";
	}

}
