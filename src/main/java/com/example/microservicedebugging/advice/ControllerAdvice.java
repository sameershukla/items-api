package com.example.microservicedebugging.advice;

import java.io.InvalidObjectException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Centralized ExceptionHandler for ItemId not found and Simple Item Name Length Validation
 * 
 * @author Sameer Shukla 
 *
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleItemNotFoundException(
        IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Item with Id Not Found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<Object> validationError(
        IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid Item Name length");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
}
