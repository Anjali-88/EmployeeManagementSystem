package com.nat.restful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	private long empId;

	@NotBlank(message = "Name must not be blank")
	private String empName;

	@NotBlank(message = "City must not be blank")
	private String empCity;

	@NotBlank(message = "State must not be blank")
	private String empState;

	@NotBlank(message = "Country must not be blank")
	private String empCountry;

	@NotBlank(message = "Email must not be blank")
	private String userId;

	@NotNull(message = "Password must be between 4 to 15 characters")
	@Size(min = 4, max = 15)
	@NotBlank(message = "Password must not be blank")
	private String empPass;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public String getEmpCountry() {
		return empCountry;
	}

	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", empState=" + empState
				+ ", empCountry=" + empCountry + ", userId=" + userId + ", empPass=" + empPass + "]";
	}

}
