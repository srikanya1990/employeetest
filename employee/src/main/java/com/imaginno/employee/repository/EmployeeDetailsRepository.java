package com.imaginno.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginno.employee.model.Employee;


/**
 * @author Srikanya
 *
 */
public interface EmployeeDetailsRepository extends JpaRepository<Employee, Long> {

}
