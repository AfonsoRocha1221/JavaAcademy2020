package com.example.JavaAcademy.Security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * The type Resource not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param message the message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);}


}
