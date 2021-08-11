package com.shoponline.jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoponline.entities.Account;

import io.jsonwebtoken.lang.Objects;
import lombok.Data;


public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;

	private String username;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	public UserDetailsImpl( String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Account user) {
		List<GrantedAuthority> authorities = user.getAuthorities().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole().getName()))
				.collect(Collectors.toList());

		return new UserDetailsImpl( 
				user.getUsername(),
				user.getPassword(), 
				authorities);
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		
		UserDetailsImpl user = (UserDetailsImpl) o;
		return java.util.Objects.equals(username, user.username);
	}

}
