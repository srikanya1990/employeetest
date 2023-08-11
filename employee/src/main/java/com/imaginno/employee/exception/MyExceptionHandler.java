package com.imaginno.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * @author Srikanya
 *
 */
@RestController
@ControllerAdvice

public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object>globalExceptionHndler(ResourceNotFoundExceptiont ex,WebRequest request){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
