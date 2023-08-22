package com.nat.restful.service;

import java.util.List;
import java.util.Optional;
import com.nat.restful.model.Employee;

import Exception.EmployeeAlreadyExistsException;
import Exception.EmployeeNotFoundException;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException;

	public boolean deleteEmployee(long id) throws EmployeeNotFoundException;

	public List<Employee> getAllEmployee();

	public Employee findEmpById(long id) throws EmployeeNotFoundException;

	public Employee updateEmployee(Employee employee, long id) throws EmployeeAlreadyExistsException;

}