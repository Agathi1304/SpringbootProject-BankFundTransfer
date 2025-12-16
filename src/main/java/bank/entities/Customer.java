package bank.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                   // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor       // Generates a no-argument constructor
@AllArgsConstructor        // Generates an all-arguments constructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	//MApping with account table
	
	@ManyToMany(cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	@JoinTable(name="customerAccounts",joinColumns= @JoinColumn(name="customerid"),
	inverseJoinColumns= @JoinColumn(name="accountid"))
	private Set<Account> accounts;
	
}
