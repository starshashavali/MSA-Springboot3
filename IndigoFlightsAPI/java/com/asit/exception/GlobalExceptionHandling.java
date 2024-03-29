package com.asit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> handleIdNotFoundException(IdNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Occured::" + ex);
	}

}
