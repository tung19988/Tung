package com.mediasoft.Order.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediasoft.Order.Entity.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {
	Order findByid(Long id);
	Page<Order> findByorderDate(Pageable Pageable);
}
