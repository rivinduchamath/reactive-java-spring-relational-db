package com.cloudofgoods.order.repository;

import com.cloudofgoods.order.entity.OrderStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends ReactiveCrudRepository <OrderStatus, Long> {
}
