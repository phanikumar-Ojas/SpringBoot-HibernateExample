package com.hibernateexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateexample.bankservice.BankService;
import com.hibernateexample.entity.BankAccount;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/bank")
public class BankAccountController {

	@Autowired
	public BankService service;

	
	@ApiOperation(value = "This is to save the given bank Account",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The BankAccount is created Successfully!!!"),
			@ApiResponse(code = 204, message = "The BankAccount details not saved") })
	@PostMapping(value = "/save")
	public ResponseEntity<?> saveBankAccount(@RequestBody BankAccount account) {
		BankAccount savedBankAccount = service.save(account);

		if (savedBankAccount == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(savedBankAccount);
	}

}
