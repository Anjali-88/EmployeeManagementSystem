package com.nat.restful.TestController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nat.restful.controller.EmployeeController;
import com.nat.restful.model.Employee;
import com.nat.restful.service.EmployeeServiceImpl;

@WebMvcTest(EmployeeController.class)

public class EmployeeTestController {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeServiceImpl employeeservice;

	private Employee employee;

	@BeforeEach
	public void setup() {
		employee = new Employee();

		employee.setEmpId(101);
		employee.setEmpName("shyam");
		employee.setEmpCity("chennai");
		employee.setEmpState("Tamilnadu");
		employee.setEmpCountry("India");
		employee.setUserId("shyam@gmail.com");
		employee.setEmpPass("1234");

		ArrayList employeeList = new ArrayList();
		employeeList.add(employee);
	}

	@AfterEach
	public void tearDown() {
		employee = null;
	}

	@Test
	public void testSaveEmployeeSuccess() throws Exception {
		Mockito.when(employeeservice.addEmployee(employee)).thenReturn(employee);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/addemployee").contentType(MediaType.APPLICATION_JSON)
				.content(asJSON(employee))).andExpect(status().isCreated());
	}

	private static String asJSON(Employee employee) {
		try {
			String empl = new ObjectMapper().writeValueAsString(employee);
			return empl;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
