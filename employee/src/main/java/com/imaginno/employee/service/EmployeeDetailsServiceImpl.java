package com.imaginno.employee.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginno.employee.dto.EmployeeDto;
import com.imaginno.employee.exception.ResourceNotFoundExceptiont;
import com.imaginno.employee.model.Employee;
import com.imaginno.employee.model.EmployeeTaxDetails;
import com.imaginno.employee.repository.EmployeeDetailsRepository;


/**
 * @author Srikanya
 *
 */
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	Logger logger = LoggerFactory.getLogger(EmployeeDetailsServiceImpl.class);

	@Autowired
	private EmployeeDetailsRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) {

		logger.debug("Enter create Employee");
		Employee employee = modelMapper.map(employeedto, Employee.class);
		EmployeeDto empDto = null;
		Employee emp = null;
		try {
			emp = employeeRepository.save(employee);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new ResourceNotFoundExceptiont("employee already existed");
		}
		empDto = modelMapper.map(emp, EmployeeDto.class);
		return empDto;

	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		logger.debug("Enter getAllEmployees");
		List<EmployeeDto> dtoList = new ArrayList<>();
		List<Employee> allemployelist = employeeRepository.findAll();
		
		for(Employee employee:allemployelist) {
			EmployeeDto dto = new EmployeeDto();
			dto = this.modelMapper.map(employee, EmployeeDto.class);
			dtoList.add(dto);
		}
		return dtoList;	
		
	}

	@Override
	public Double taxdeductionForCurrentYear(Long id) {

		Double tax = 0.0;
		Double cess = 0.0;
		EmployeeTaxDetails employeetaxdetails = new EmployeeTaxDetails();
		Employee employeebyid = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptiont("EmployeeNotFoundException"));

		EmployeeDto employeeDto = modelMapper.map(employeebyid, EmployeeDto.class);
		LocalDate employeestartingdate = employeeDto.getDoj();
		LocalDate employeeendingdate = LocalDate.now();
		long totalemployeemonthsworking = ChronoUnit.MONTHS.between(employeestartingdate, employeeendingdate);
		Double totalsalaryofemployee = employeeDto.getSalary() * totalemployeemonthsworking;

		if (totalsalaryofemployee > 250000 && totalsalaryofemployee <= 500000) {

			tax = (totalsalaryofemployee - 250000) * 0.05;

		} else if (totalsalaryofemployee > 500000 && totalsalaryofemployee <= 1000000) {
			tax = 12500 + (totalsalaryofemployee - 500000) * 0.1;
		} else if (totalsalaryofemployee > 1000000) {

			tax = 112500 + (totalsalaryofemployee - 1000000) * 0.2;
		}

		if (totalsalaryofemployee > 2500000) {
			cess = (totalsalaryofemployee - 2500000) * 0.02;
		}
		double employeetotaltax = tax + cess;
		employeetaxdetails.setEmployeeID(employeeDto.getEmpId());
		employeetaxdetails.setFirstName(employeeDto.getFirstname());
		employeetaxdetails.setLastName(employeeDto.getLastname());
		employeetaxdetails.setEmail(employeeDto.getEmail());
		employeetaxdetails.setPhoneNumber(employeeDto.getPhoneNumber());
		employeetaxdetails.setDOJ(employeeDto.getDoj());
		employeetaxdetails.setSalary(employeeDto.getSalary());
		employeetaxdetails.setTotalTexAmount(tax);
		employeetaxdetails.setTotalCessAmount(cess);

		return employeetotaltax;
	}

}
