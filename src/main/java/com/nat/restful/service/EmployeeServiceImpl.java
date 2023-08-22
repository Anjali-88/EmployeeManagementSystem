package com.nat.restful.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nat.restful.model.Employee;
import com.nat.restful.repository.IEmployeeRepository;

import Exception.EmployeeAlreadyExistsException;
import Exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeerepository;

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {

		Optional<Employee> optional = this.employeerepository.findById(employee.getEmpId());
		Employee empObj = null;
		if (optional.isPresent()) {
			System.out.println("User Already Exists!");
		} else {
			empObj = this.employeerepository.save(employee);
		}
		return empObj;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeerepository.findAll();
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(long id) throws EmployeeNotFoundException {
		Optional<Employee> optional = this.employeerepository.findById(id);
		Employee empObj = null;
		boolean status = false;
		if (optional.isPresent()) {
			this.employeerepository.delete(optional.get());
			status = true;
		}
		return status;
	}

	@Override
	public Employee findEmpById(long id) throws EmployeeNotFoundException {
		Optional<Employee> optional = this.employeerepository.findById(id);
		Employee empObj = null;
		if (optional.isPresent()) {
			empObj = optional.get();
		}
		return empObj;
	}

	@Override
	public Employee updateEmployee(Employee empObj, long id) throws EmployeeAlreadyExistsException {
		Optional<Employee> Optional = employeerepository.findById(id);
		Employee employee = null;
		Employee updateEObj = null;
		if (Optional.isPresent()) {
			System.out.println("Record related to the user exists !!!");
			employee = Optional.get();
			employee.setEmpId(empObj.getEmpId());
			employee.setEmpName(empObj.getEmpName());
			employee.setEmpCity(empObj.getEmpCity());
			employee.setEmpState(empObj.getEmpState());
			employee.setEmpCountry(empObj.getEmpCountry());
			employee.setUserId(empObj.getUserId());
			employee.setEmpPass(empObj.getEmpPass());
			updateEObj = this.employeerepository.save(empObj);
		}
		return updateEObj;
	}
}
