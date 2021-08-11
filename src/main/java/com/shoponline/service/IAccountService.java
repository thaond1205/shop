package com.shoponline.service;

import java.util.List;

import com.shoponline.entities.Account;

public interface IAccountService {
	
	Account findById(String username);
	
	List<Account> findAll();
	
	List<Account> getAdmin();
}	
