package com.hibernateexample.employeedao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateexample.entity.Employee;
import com.hibernateexample.repository.EmployeeRepository;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee save(Employee entity) {

		return repo.save(entity);
	}

	@Override
	public List<Employee> getAll() {
		return repo.findAll();
	}

	@Override
	public Employee getById(Serializable id) {
		return repo.findById((Integer) id).orElse(null);
	}

	@Override
	public void delete(Serializable id) {
		repo.deleteById((Integer) id);
	}

}
