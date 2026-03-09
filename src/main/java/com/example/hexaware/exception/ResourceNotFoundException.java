package com.example.hexaware.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mes)
	{
		super(mes);
	}

}
