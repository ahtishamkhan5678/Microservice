package com.mohmmad.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mohmmad.Payload.ApiRespone;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
		@ExceptionHandler(ResourceNotFoundException.class)// the exception is related to that class this below method call;
		public ResponseEntity<ApiRespone> handlerResourceNOtFoundException(ResourceNotFoundException rne){
			
			String message = rne.getMessage();
			
		    ApiRespone response =	ApiRespone.builder().message(message).success(true)
                      .status(HttpStatus.NOT_FOUND).build();	
			
			
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			
		}

}
