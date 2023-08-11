package com.imaginno.employee.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Srikanya
 *
 */
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	private LocalDate doj;
	@Column(nullable = false)
	private Double salary;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee(Long empId, String firstname, String lastname, String email, String phoneNumber, LocalDate doj,
			Double salary) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
	}
	public Employee(String firstname, String lastname, String email, String phoneNumber, LocalDate doj, Double salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", doj=" + doj + ", salary=" + salary + "]";
	}
	public Employee() {
		super();
	}
	
	
	

}
