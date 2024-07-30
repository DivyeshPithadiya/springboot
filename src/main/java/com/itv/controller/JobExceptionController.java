package com.itv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itv.exceptions.JobNotFoundException;

@RestControllerAdvice
public class JobExceptionController {

	@ExceptionHandler(JobNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleJobNotFoundException(JobNotFoundException e) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		
		ex.getFieldErrors().forEach((error)-> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
}
