package com.CodewithblogApplication.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.CodewithblogApplication.payLoads.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> resourceNotFoundException( ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		APIResponse apiResponse=new APIResponse(message,false);
		return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.NOT_FOUND);		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handeMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		//map use to collect all error message
		Map<String, String> response= new HashMap<>();
		
		// find from exception(ex) bind result then find all errors then get one by one error from error object 
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldname = ((FieldError)error).getField();   // error object  type cast in fieldError
			String message = error.getDefaultMessage();
			// add fieldname and message in map
			response.put(fieldname, message);
			
		});
		
		
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);		
	}

}
