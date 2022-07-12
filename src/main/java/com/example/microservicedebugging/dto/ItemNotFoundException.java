package com.example.microservicedebugging.dto;

public class ItemNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException() {
		
	}

	public ItemNotFoundException(Integer id) {

	        super(String.format("Item with Id %d not found", id));
	    }
	
}
