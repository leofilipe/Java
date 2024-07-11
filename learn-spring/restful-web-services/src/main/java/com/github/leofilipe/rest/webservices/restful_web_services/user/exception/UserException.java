package com.github.leofilipe.rest.webservices.restful_web_services.user.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserException {

	private LocalDateTime timeStamp;
	
	private String message;
	
	private String details;

	public UserException(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
