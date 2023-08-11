package com.imaginno.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptiont extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundExceptiont(String msg) {
		super(msg);
	}
}
