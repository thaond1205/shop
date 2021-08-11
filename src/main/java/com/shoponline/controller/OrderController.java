package com.shoponline.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoponline.service.impl.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/checkout")
    public String viewCheckout(){
        return "order/checkout";
    }
  
    @RequestMapping("/order/list")
    public String viewOrderList(Model model, HttpServletRequest request){
    	String username = request.getRemoteUser();
    	model.addAttribute("order", orderService.findByUsername(username));
        return "order/list";
    }

    @RequestMapping("/order/detail/{id}")
    public String viewOrderDetail(@PathVariable("id") Long id, Model model){
    	model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }
}
