package com.nit.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.order.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
Optional<List<OrderItem>> findByProductname (String productname);
}
