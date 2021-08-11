package com.shoponline.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.shoponline.entities.Order;

public interface IOrderService {
	Order create(JsonNode nodeData);
	Order findById(Long id);
	List<Order> findByUsername(String username);
}
