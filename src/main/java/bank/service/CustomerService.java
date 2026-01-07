package bank.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bank.entities.Account;
import bank.entities.Customer;
import bank.exception.CustomerExceptions;
import bank.repository.CustomerRepository;
import bank.service.implementation.customerService;

@Service
public class CustomerService implements customerService {

	private CustomerRepository customerRepo;
	
	public CustomerService(CustomerRepository customerRepoistory) {
		this.customerRepo=customerRepoistory;
	}
	
	public ResponseEntity<Customer> createCustomer(Customer cust){
		Customer customer = customerRepo.save(cust);
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
	}
	
	public List<Customer> getAllCustomer(){
		//return customerRepo.findAll();
		List<Customer> customer = customerRepo.findAll();
		if(customer.isEmpty()) {
			throw new CustomerExceptions("No such customer found in db");
		}
		return customer;
	}
	
	 
	public Customer getCustomer(int customerId) {
//		Customer customer = customerRepo.findById(customerId).orElse(null);
//		if(customer!=null) return customer;
//		return null;
		
		return customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerExceptions("Customer not found with ID: " + customerId));
	}
	
	
	 @Transactional
	public Customer updateCustomer(Customer cust,int customerId) {
//		Customer customer = customerRepo.findById(customerId).orElse(null);
		
		Customer exisitingCustomer = customerRepo.findById(customerId)
				.orElseThrow(()-> new CustomerExceptions("Cannot update - customer not found with ID: "+customerId));
		
		exisitingCustomer.setEmail(cust.getEmail());
		exisitingCustomer.setFirstName(cust.getFirstName());
		exisitingCustomer.setLastName(cust.getLastName());
		
		// Update the first (and only) account
	    if (cust.getAccounts() != null && !cust.getAccounts().isEmpty()) {
	        Account incomingAcc = cust.getAccounts().iterator().next();
	        Account existingAcc = exisitingCustomer.getAccounts().iterator().next();

	        existingAcc.setAccountType(incomingAcc.getAccountType());
	        existingAcc.setBalance(incomingAcc.getBalance());
	    }

		
		return customerRepo.save(exisitingCustomer);
	}
		
	public Customer deleteCustomer(int customerId) {
//		Customer customer = customerRepo.findById(customerId).orElse(null);
//		if(customer!=null) {
//			customerRepo.deleteById(customerId);
//			return customer;
//			}
//	return null;
		
		Customer deletecustomer= customerRepo.findById(customerId)
				.orElseThrow(()-> new CustomerExceptions("Cannot delete - cusomer not found with id: "+customerId));
		
		 customerRepo.deleteById(customerId);
		 
		 return deletecustomer;
		
	}
}
