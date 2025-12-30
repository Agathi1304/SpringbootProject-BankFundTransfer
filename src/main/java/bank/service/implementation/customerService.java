package bank.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import bank.entities.Customer;

public interface customerService {

	ResponseEntity<Customer> createCustomer(Customer cust);
	List<Customer> getAllCustomer();
	Customer getCustomer(int customerId);
	Customer updateCustomer(Customer cust,int customerId);
	Customer deleteCustomer(int customerId);
	
}
