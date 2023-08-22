package com.nat.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.restful.model.Employee;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
