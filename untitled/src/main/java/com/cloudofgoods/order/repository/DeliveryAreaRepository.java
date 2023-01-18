package com.cloudofgoods.order.repository;


import com.cloudofgoods.order.entity.DeliveryArea;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAreaRepository extends ReactiveCrudRepository <DeliveryArea, Long> {
}
