package com.hibernateexample.bankdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateexample.entity.BankAccount;
import com.hibernateexample.repository.BankRepository;

@Component
public class BankDAOImpl implements BankDAO {

	@Autowired
	private BankRepository bankRepository;

	@Override
	public BankAccount Save(BankAccount bank) {
		return bankRepository.save(bank);
	}

	@Override
	public BankAccount getById(Integer id) {
		return bankRepository.getOne(id);
	}

	@Override
	public List<BankAccount> findAll() {
		return bankRepository.findAll();
	}

}
