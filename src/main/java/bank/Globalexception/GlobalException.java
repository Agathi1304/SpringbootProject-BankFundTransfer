package bank.Globalexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import bank.exception.AccountExceptions;
import bank.exception.CustomerExceptions;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomerExceptions.class)
	public ResponseEntity<CustomErrorResponse> handleCustomerRelatedExceptions(CustomerExceptions exception){
		CustomErrorResponse error = new CustomErrorResponse("404",exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<CustomErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountExceptions.class)
	public ResponseEntity<CustomErrorResponse> handleAccountRelatedExceptions(AccountExceptions exception){
		CustomErrorResponse error = new CustomErrorResponse("404","NotFoundException");
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<CustomErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
