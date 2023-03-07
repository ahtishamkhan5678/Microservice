package com.mohmmad.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
		@ExceptionHandler(ResourceNotFoundException.class)// the exception is related to that class this below method call;
		public ResponseEntity<Map<String , Object>> notFoundException(ResourceNotFoundException rne){
			
		    Map map= new HashMap();	
			map.put("message", rne.getMessage());
			
			map.put("success",false);
			map.put("status",HttpStatus.NOT_FOUND);
			
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
			
		}

}