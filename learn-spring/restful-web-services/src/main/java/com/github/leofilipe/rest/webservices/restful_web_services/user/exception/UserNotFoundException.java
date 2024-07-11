package com.github.leofilipe.rest.webservices.restful_web_services.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1114848890971301452L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
