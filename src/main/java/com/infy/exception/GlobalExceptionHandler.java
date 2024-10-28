package com.infy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(value= {LoginExcep.class})
	public ResponseEntity<ApiError> LoginException(LoginExcep exp) {
//		String message = exp.getMessage();
//		Integer code=101;
		
		ApiError error=new ApiError();
		error.setErrorCode(101);
		error.setMassage("Login Failed");
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);				
	}
	
	@ExceptionHandler(value= {IdNotFound.class})
	public ResponseEntity<ApiError> idNotfoundException(IdNotFound idnotfound ){
		ApiError error=new ApiError();
		error.setErrorCode(202);
		error.setMassage("Id not present");
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}
}
