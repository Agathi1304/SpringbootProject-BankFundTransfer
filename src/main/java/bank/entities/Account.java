package bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                   // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor       // Generates a no-argument constructor
@AllArgsConstructor      // Generates an all-arguments constructor

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;
	
	@Enumerated(EnumType.STRING)
	private Accountype accountType;
	
	private double balance;
}
