package com.shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoponline.entities.Role;
import com.shoponline.reposiitories.RolesRepository;
import com.shoponline.service.IRolesService;

@Service
public class RolesService implements IRolesService{
	
	@Autowired
	private RolesRepository rolesRepository;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

}
