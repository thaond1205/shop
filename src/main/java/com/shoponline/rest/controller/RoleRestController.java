package com.shoponline.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.shoponline.entities.Order;
import com.shoponline.entities.Product;
import com.shoponline.entities.Role;
import com.shoponline.service.impl.OrderService;
import com.shoponline.service.impl.ProductService;
import com.shoponline.service.impl.RolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	@Autowired
	private RolesService rolesService;

	@GetMapping()
	public List<Role> findAll() {
		return rolesService.findAll();
	}

}
