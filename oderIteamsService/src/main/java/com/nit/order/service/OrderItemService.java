package com.nit.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.order.model.OrderItem;
import com.nit.order.repository.OrderItemRepository;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;

	public   OrderItem saveOrderItem(OrderItem orderiteam) {
		
		return orderItemRepository.save(orderiteam);
	}

	public Iterable<OrderItem> getAllOderIeams() {
		
		return orderItemRepository.findAll();
	}

	public Optional<List<OrderItem>> findByNameProductname(String productname) {
		
		return orderItemRepository.findByProductname(productname);
	}

}
