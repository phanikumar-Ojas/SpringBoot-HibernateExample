package com.hibernateexample.bankservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateexample.bankdao.BankDAO;
import com.hibernateexample.entity.BankAccount;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO dao;

	@Override
	public BankAccount save(BankAccount account) {
		return dao.Save(account);
	}

	@Override
	public BankAccount getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<BankAccount> findAll() {
		return dao.findAll();
	}

}
