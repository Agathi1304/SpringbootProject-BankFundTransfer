package bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TranscationExceptions extends RuntimeException{

	public static final long serialVersionID=1L;
	
	public TranscationExceptions(String message) {
		super(message);
	}
}
