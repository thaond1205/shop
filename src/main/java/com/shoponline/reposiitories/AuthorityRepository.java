package com.shoponline.reposiitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoponline.entities.Account;
import com.shoponline.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authorityOf(List<Account> accounts);
}
