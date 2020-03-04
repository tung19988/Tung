package com.mediasoft.Order.Service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mediasoft.Order.Entity.Order;

@Repository
public interface OrderPageRepo extends PagingAndSortingRepository<Order, Long>  {
}
