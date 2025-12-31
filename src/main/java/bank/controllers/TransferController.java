package bank.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bank.entities.Account;
import bank.entities.FundTransferDetails;
import bank.service.FundTransferService;

@RestController
public class TransferController {
	
	FundTransferService fundTransferService;
	
	public TransferController(FundTransferService fundservice) {
		this.fundTransferService=fundservice;
	}

	@PutMapping("/api/transferAmount")
	public String FundTransfer(@RequestBody FundTransferDetails transfer) {
		
		String msg = fundTransferService.fundTransfer(transfer.getFromAccount(),transfer.getToAccount(),transfer.getAmount());
		return msg;
	}
}
