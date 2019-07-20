package application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
	private String message;
	private long code;
	private String resourceName;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	
	public ResourceNotFound() {
		super();
		message="Resource unavailable !";
		code=404L;
	}
	public ResourceNotFound(String message, long code, String resourceName) {
		super();
		this.message = message;
		this.code = code;
		this.resourceName = resourceName;
	}
	
	

}
