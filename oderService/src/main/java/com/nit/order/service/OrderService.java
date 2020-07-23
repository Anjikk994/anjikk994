package com.nit.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.order.model.Order;
import com.nit.order.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public Order crateOreder(Order order) {
		
		return orderRepository.save(order);
	}

}
