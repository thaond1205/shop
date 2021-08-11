package com.shoponline.service;

import java.util.List;

import com.shoponline.entities.Authority;

public interface IAuthorityService {
	
	List<Authority> findAuthoritiesOfAdministrator();
	
	List<Authority> findAll();
	
	Authority create(Authority authority);
	
	void delete(Integer id);
}
