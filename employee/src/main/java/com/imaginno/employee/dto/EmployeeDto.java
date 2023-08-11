package com.imaginno.employee.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeDto {
	private Long empId;
	@NotNull(message = " required firstname ")
	private String firstname;
	@NotNull(message = " required lastname")
	private String lastname;
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotNull(message = " required Email")
	private String email;
	@NotBlank(message = "required atleast one Phone no")
	@Pattern(regexp="^[0-9\\-]+$")
	private String phoneNumber;
	@NotNull(message = " required Date of joining ")
	private LocalDate doj;
	private Double salary;
	
	public EmployeeDto(Long empId, @NotNull(message = " required firstname ") String firstname,
			@NotNull(message = " required lastname") String lastname,
			@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") @NotNull(message = " required Email") String email,
			@NotBlank(message = "required atleast one Phone no") @Pattern(regexp = "^[0-9\\-]+$") String phoneNumber,
			@NotNull(message = " required Date of joining ") LocalDate doj, Double salary) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
	}

	public EmployeeDto(@NotNull(message = " required firstname ") String firstname,
			@NotNull(message = " required lastname") String lastname,
			@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") @NotNull(message = " required Email") String email,
			@NotBlank(message = "required atleast one Phone no") @Pattern(regexp = "^[0-9\\-]+$") String phoneNumber,
			@NotNull(message = " required Date of joining ") LocalDate doj, Double salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
	}

	public EmployeeDto() {
		super();
	}

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

	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", doj=" + doj + ", salary=" + salary + "]";
	}
	
	
	
	
}