package com.cloudofgoods.order.repository;

import com.cloudofgoods.order.entity.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCrudRepository <Order, Long> {
}
