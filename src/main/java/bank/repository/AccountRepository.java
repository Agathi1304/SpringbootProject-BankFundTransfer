package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

//	1.Native query
//	@Query(value="select * from Account where ACCOUNT_NUMBER =?1",nativeQuery = true)
//	public Account findByAccountNumber(double accountNumber);
	
	/**
	 * Instead of a native query, use Spring Data JPA’s derived query method.
        Spring automatically maps entity fields to columns based on your @Column annotations.
	 */
	public Account findByAccountNumber(int accountnumber);
	
}
