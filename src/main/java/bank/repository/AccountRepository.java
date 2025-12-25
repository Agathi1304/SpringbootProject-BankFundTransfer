package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
