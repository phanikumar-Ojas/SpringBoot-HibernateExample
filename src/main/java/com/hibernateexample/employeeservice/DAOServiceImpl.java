package com.hibernateexample.employeeservice;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateexample.employeedao.EmployeeDAO;
import com.hibernateexample.entity.Employee;

@Service
public class DAOServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee geEmployeeById(Serializable id) {
		//
		return dao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public void deleEmployeee(Serializable id) {
		dao.delete(id);

	}

}
