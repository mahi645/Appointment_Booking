package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorInfo> invalidName(InvalidNameException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> idNotFound(IdNotFoundException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidExperienceException.class)
	public ResponseEntity<ErrorInfo> invalidExperienc(InvalidExperienceException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.NOT_ACCEPTABLE.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.NOT_ACCEPTABLE);
	}
}
