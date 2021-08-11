package com.shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoponline.entities.Account;
import com.shoponline.reposiitories.AccountRepository;
import com.shoponline.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account findById(String username) {
		return accountRepository.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public List<Account> getAdmin() {
		// TODO Auto-generated method stub
		return accountRepository.getAdmin();
	}

}
