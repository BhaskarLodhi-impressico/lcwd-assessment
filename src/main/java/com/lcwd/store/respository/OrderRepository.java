package com.lcwd.store.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
	List<Order> findByUserId(String userId);
}
