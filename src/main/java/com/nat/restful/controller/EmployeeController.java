package com.nat.restful.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nat.restful.model.Employee;
import com.nat.restful.service.IEmployeeService;

import Exception.EmployeeAlreadyExistsException;
import Exception.EmployeeNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeservice;
	private ResponseEntity responseentity;

	@PostMapping("/addemployee")
	public ResponseEntity saveData(@Valid @RequestBody Employee empObj) {
		ResponseEntity respentity = null;
		try {

			Employee employee = this.employeeservice.addEmployee(empObj);
			respentity = new ResponseEntity(employee, HttpStatus.CREATED);
		} catch (EmployeeAlreadyExistsException eaeObj) {
			System.out.println(eaeObj.getMessage());
		}
		return respentity;
	}

	@GetMapping("/all")
	public ResponseEntity getAllEmployeeData() {
		List<Employee> employee = this.employeeservice.getAllEmployee();
		ResponseEntity respentity = new ResponseEntity(employee, HttpStatus.OK);
		return respentity;
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity deleteUserDataById(@PathVariable long id) {
		ResponseEntity respentity = null;
		try {
			boolean status = this.employeeservice.deleteEmployee(id);
			respentity = new ResponseEntity("User Deleted successfully !!!", HttpStatus.OK);
		} catch (EmployeeNotFoundException enfobj) {
			System.out.println(enfobj.getMessage());
		}

		return respentity;
	}

	@GetMapping("/findEmployee/{id}")
	public ResponseEntity getUserDataById(@PathVariable long id) {
		ResponseEntity respentity = null;
		try {
			Employee employee = this.employeeservice.findEmpById(id);
			respentity = new ResponseEntity(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException enfobj) {
			System.out.println(enfobj.getMessage());
		}

		return respentity;
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity updateData(@Valid @RequestBody Employee empObj, @PathVariable long id) {

		ResponseEntity respentity = null;
		try {
			Employee employee = this.employeeservice.updateEmployee(empObj, id);
			respentity = new ResponseEntity(employee, HttpStatus.OK);
		} catch (EmployeeAlreadyExistsException eaefobj) {
			System.out.println(eaefobj.getMessage());
		}
		return respentity;
	}

}