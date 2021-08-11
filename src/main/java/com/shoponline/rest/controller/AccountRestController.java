package com.shoponline.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoponline.entities.Account;
import com.shoponline.service.impl.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	private AccountService accountService;

	@GetMapping()
	public List<Account> getAccount(@RequestParam("admin") Optional<Boolean> admin) {
		if(admin.orElse(false)) {
			return accountService.getAdmin();
		}
		return accountService.findAll();
	}

}
