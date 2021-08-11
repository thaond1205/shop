package com.shoponline.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoponline.entities.Order;
import com.shoponline.entities.OrderDetail;
import com.shoponline.reposiitories.OrderDetailRepository;
import com.shoponline.reposiitories.OrderRepository;
import com.shoponline.service.IOrderService;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository; 

	@Override  
	public Order create(JsonNode orderData) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderRepository.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		orderDetailRepository.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long id) { 
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		
		return orderRepository.findByUsername(username);
	}

}
