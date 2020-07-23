package com.nit.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.order.model.Order;
import com.nit.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderContoller {
	@Autowired
	private OrderService orderService;
	
	
	
@PostMapping("/create")	
public Order createOrder(@RequestBody Order order) {
	return orderService.crateOreder(order);
	
}
}
