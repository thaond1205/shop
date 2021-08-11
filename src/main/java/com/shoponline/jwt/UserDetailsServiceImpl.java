package com.shoponline.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoponline.entities.Account;
import com.shoponline.reposiitories.AccountRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("Khong tim thay!" + username));
		return UserDetailsImpl.build(account);
	}

}
