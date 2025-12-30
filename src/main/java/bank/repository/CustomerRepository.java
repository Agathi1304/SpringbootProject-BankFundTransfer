package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
