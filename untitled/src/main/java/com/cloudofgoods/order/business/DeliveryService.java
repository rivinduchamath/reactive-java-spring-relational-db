package com.cloudofgoods.order.business;

import com.cloudofgoods.order.dto.DeliveryAreaDTO;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

public interface DeliveryService {
    Mono <DeliveryAreaDTO> saveDelivery(DeliveryAreaDTO deliveryAreaDTO) throws ExecutionException, InterruptedException;
}
