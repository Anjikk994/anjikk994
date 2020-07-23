package com.nit.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nit.order.model.OrderItem;
import com.nit.order.service.OrderItemService;

@RestController
@RequestMapping("/Order")
public class OrderItemContoller {
	
	
	
	@Autowired
	private OrderItemService orderItemService;

	@PostMapping("/createOrderIlteam")
	public OrderItem createOrderIteam(@RequestBody OrderItem orderitem) {

		return orderItemService.saveOrderItem(orderitem);

	}
	@GetMapping("/getAllOderIteams")
	public Iterable<OrderItem> getAllOrderItem() {
		return orderItemService.getAllOderIeams();
		
	}
	@GetMapping("/getAllOderIteams/{productname}")
	public Optional<List<OrderItem>> getBasedOnProductname(@PathVariable String productname ) {
		return orderItemService.findByNameProductname(productname);
		
	}
	
}
