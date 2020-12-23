package com.hibernateexample.employeeservice;

import java.io.Serializable;
import java.util.List;

import com.hibernateexample.entity.Employee;

public interface EmployeeService {

	Employee save(Employee enEmployeeiEmployeey);

	Employee geEmployeeById(Serializable id);

	List<Employee> getAll();

	void deleEmployeee(Serializable id);

}
