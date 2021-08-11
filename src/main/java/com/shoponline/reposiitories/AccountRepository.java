package com.shoponline.reposiitories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoponline.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdmin();
	
	
	Optional<Account> findByUsername(String username);
	

	
}
