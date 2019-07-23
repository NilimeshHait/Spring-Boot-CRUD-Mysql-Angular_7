package com.nilimesh.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nilimesh.spring.entities.UserError;
import com.nilimesh.spring.exception.ERROR_MessageException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(ERROR_MessageException.class)
	public ResponseEntity<UserError> mapException(ERROR_MessageException ex){
		UserError userError=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(userError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
