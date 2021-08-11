package com.shoponline.rest.controller;

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
import com.shoponline.service.impl.OrderService;
import com.shoponline.service.impl.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	private OrderService orderService;

	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}

}
