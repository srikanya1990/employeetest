package com.imaginno.employee.service;

import java.util.List;

import com.imaginno.employee.dto.EmployeeDto;



/**
 * @author Srikanya
 *
 */
public interface EmployeeDetailsService {
	
	public EmployeeDto createEmployee(EmployeeDto dto);

	public 	List<EmployeeDto> getAllEmployee();
	

	Double taxdeductionForCurrentYear(Long id);
}
