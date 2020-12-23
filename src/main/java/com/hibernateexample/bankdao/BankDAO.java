package com.hibernateexample.bankdao;

import java.util.List;

import com.hibernateexample.entity.BankAccount;

public interface BankDAO {

	public BankAccount Save(BankAccount bank) ;

	public BankAccount getById(Integer id);

	public List<BankAccount> findAll();

}
