package com.imaginno.employee.conroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginno.employee.dto.EmployeeDto;
import com.imaginno.employee.service.EmployeeDetailsServiceImpl;


/**
 * @author Srikanya
 *
 */
@RestController
@RequestMapping("imaginnovate/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeDetailsServiceImpl employeeDetailsService;
	
	Logger logger =LoggerFactory.getLogger(EmployeeController.class);
	
	
	/**
	 * @param employeedto
	 * @param bindingResult
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> addemploye(@Validated @RequestBody EmployeeDto employeedto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

			EmployeeDto st = employeeDetailsService.createEmployee(employeedto);
	        logger.debug("A DEBUG Message");
			return new ResponseEntity<EmployeeDto>(st, HttpStatus.CREATED);
		}
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getallemployees(){
			
		List<EmployeeDto> employess = employeeDetailsService.getAllEmployee();

		return new ResponseEntity<List<EmployeeDto>>(employess, HttpStatus.OK);

	}
	

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> taxDeductionCurrentYear(@PathVariable("id")Long id){
		return new ResponseEntity<Double>(employeeDetailsService.taxdeductionForCurrentYear(id),HttpStatus.OK);
		
	}
	

}
