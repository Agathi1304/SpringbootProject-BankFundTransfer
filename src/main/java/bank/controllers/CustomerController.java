package bank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bank.entities.Customer;
import bank.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerservice;
	
	public CustomerController(CustomerService custservice) {
		this.customerservice = custservice;
	}

	@PostMapping("/api/customer/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust){
		return customerservice.createCustomer(cust);
	}
	
	@GetMapping("/api/customer/getAll")
	public List<Customer> getAllCustomer(){
		return customerservice.getAllCustomer();
	}
	
	@GetMapping("/api/customer/get/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customerservice.getCustomer(customerId);
	}
	
	@PutMapping("/api/customer/update/{customerId}")
	public Customer updateCustomer(@RequestBody Customer cust,@PathVariable int customerId) {
		return customerservice.updateCustomer(cust, customerId);
	}
	
	@DeleteMapping("/api/customer/delete/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		return customerservice.deleteCustomer(customerId);
	}
}
