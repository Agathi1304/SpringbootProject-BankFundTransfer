package bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerExceptions extends RuntimeException {
	
	public static final long serialVersionID=1L;
	
	public CustomerExceptions(String message) {
		super(message);
	}

}
