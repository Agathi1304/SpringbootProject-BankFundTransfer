package bank.Globalexception;

import java.time.LocalDateTime;

public class CustomErrorResponse {

	LocalDateTime timestamp;
	String status;
	String errorCode;
	String message;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public CustomErrorResponse(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public CustomErrorResponse(LocalDateTime timestamp, String status, String errorCode, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
