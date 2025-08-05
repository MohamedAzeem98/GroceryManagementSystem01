package com.gms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest req){
		ErrorResponse error=new ErrorResponse(ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex,WebRequest req){
		ErrorResponse error=new ErrorResponse(ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnauthorizedActionException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorized(UnauthorizedActionException ex, WebRequest req){
		ErrorResponse error=new ErrorResponse(ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
	}
	
}
