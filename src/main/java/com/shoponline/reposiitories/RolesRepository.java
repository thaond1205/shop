package com.shoponline.reposiitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoponline.entities.Role;

public interface RolesRepository extends JpaRepository<Role, String>{
	
	Optional<Role> findByName(String name);
}
