package com.hibernateexample.employeedao;

import java.io.Serializable;
import java.util.List;

import com.hibernateexample.entity.Employee;

public interface EmployeeDAO {

	Employee save(Employee entity);

	Employee getById(Serializable id);

	List<Employee> getAll();

	void delete(Serializable id);

}
