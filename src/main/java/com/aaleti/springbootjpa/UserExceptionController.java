package com.aaleti.springbootjpa;

import java.security.InvalidParameterException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = { InvalidParameterException.class })
	public ResponseEntity<Object> throwInvalidParamException(Exception e) {

		System.out.println(e.getMessage() + "");

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> throwFileNotFoundException() {

		return null;
	}

	public ResponseEntity<Object> throwFileNotFoundException2() {

		return null;
	}

}
