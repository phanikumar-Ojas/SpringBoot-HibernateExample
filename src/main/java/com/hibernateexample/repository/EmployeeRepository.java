package com.hibernateexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernateexample.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
