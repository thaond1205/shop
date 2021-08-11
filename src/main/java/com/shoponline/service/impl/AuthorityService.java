package com.shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoponline.entities.Account;
import com.shoponline.entities.Authority;
import com.shoponline.reposiitories.AccountRepository;
import com.shoponline.reposiitories.AuthorityRepository;
import com.shoponline.service.IAuthorityService;

@Service
public class AuthorityService implements IAuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrator() {
		List<Account> accounts = accountRepository.getAdmin();
		return authorityRepository.authorityOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityRepository.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		// TODO Auto-generated method stub
		return authorityRepository.save(authority);
	}

	@Override
	public void delete(Integer id) {
		authorityRepository.deleteById(id);
		
	}

}
