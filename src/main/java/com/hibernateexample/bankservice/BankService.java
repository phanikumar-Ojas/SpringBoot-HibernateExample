package com.hibernateexample.bankservice;

import java.util.List;

import com.hibernateexample.entity.BankAccount;

public interface BankService {

	BankAccount save(BankAccount account);

	BankAccount getById(Integer id);

	List<BankAccount> findAll();

}
