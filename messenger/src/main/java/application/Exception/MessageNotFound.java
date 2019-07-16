package application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class MessageNotFound extends RuntimeException {
	private String message;
	private String code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public MessageNotFound() {
		super();
		message="Resource unavailable !";
		code="404";
	}
	public MessageNotFound(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	

}
