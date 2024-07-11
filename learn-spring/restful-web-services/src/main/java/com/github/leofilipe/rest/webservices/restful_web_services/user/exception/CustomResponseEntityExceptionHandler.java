package com.github.leofilipe.rest.webservices.restful_web_services.user.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<UserException> handleAllExceptions(Exception ex, WebRequest request) throws Exception {

		UserException userException = new UserException(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<UserException>(userException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<UserException> handleUserNotFoundExceptions(Exception ex, WebRequest request)
			throws Exception {

		UserException userException = new UserException(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<UserException>(userException, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		UserException userException = new UserException(
				LocalDateTime.now(), 
				ex.getMessage(), //ex.getFieldError().getDefaultMessage() shows 1st of messages errors only
								 //"Total erros: "+ ex.getErrorCount() + "; 1st Error: " + ex.getFieldError().getDefaultMessage() 
				request.getDescription(false));

		return new ResponseEntity<Object>(userException, HttpStatus.BAD_REQUEST);

		// return handleExceptionInternal(ex, null, headers, status, request);
	}
}
