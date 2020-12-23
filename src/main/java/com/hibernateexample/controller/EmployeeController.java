package com.hibernateexample.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateexample.employeeservice.EmployeeService;
import com.hibernateexample.entity.Employee;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "It is used to insert a employee")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully employee created"),
			@ApiResponse(code = 204, message = "No content to insert") })
	@PostMapping(value = "/save")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee) {

		Employee save = employeeService.save(employee);
		if (Objects.nonNull(save)) {
			return ResponseEntity.ok(save);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "This EndPoint is used to retrieve all the employees")
	@ApiResponses({ @ApiResponse(code = 200, message = "Retrieved Successfully"),
			@ApiResponse(code = 204, message = "No employees found") })

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> all = employeeService.getAll();
		if (all == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(all);
	}

	@ApiOperation(value = "This will deletes the employee based on the given employee id")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Employee deleted Successfully"),
			@ApiResponse(code = 500, message = "Some internal error occured"),
			@ApiResponse(code = 404, message = "Sorry Employee didnt found with the given employee id") })
	@DeleteMapping(value = "{id}/delete")
	public ResponseEntity<?> deleteEmployeeById(Integer id) {
		Employee employeeById = employeeService.geEmployeeById(id);
		if (employeeById == null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.deleEmployeee(id);

		return ResponseEntity.noContent().build();
	}

}
