package bank.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bank.entities.Customer;
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
		return customerRepo.findAll();
	}
	
	public Customer getCustomer(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(null);
		if(customer!=null) return customer;
		return null;
	}
	
	public Customer updateCustomer(Customer cust,int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(null);
		
		if(customer!=null) {
			customer.setEmail(cust.getEmail());
			customer.setFirstName(cust.getFirstName());
			customer.setLastName(cust.getLastName());
			
			return customerRepo.save(customer);
		}
		
		return customer;
	}
		
	public Customer deleteCustomer(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(null);
		if(customer!=null) {
			customerRepo.deleteById(customerId);
			return customer;
			}
	return null;
	}
}
