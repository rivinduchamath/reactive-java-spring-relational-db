package com.cloudofgoods.order.business.impl;

import com.cloudofgoods.order.business.OrderStatusService;
import com.cloudofgoods.order.dto.OrderStatusDTO;
import com.cloudofgoods.order.entity.OrderStatus;
import com.cloudofgoods.order.repository.OrderStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    private  OrderStatusRepository orderRepository;
    @Override
    public OrderStatusDTO saveOrderStatus(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatusService = new OrderStatus ();
        if(orderStatusDTO.getId() != null) orderStatusService.setId(orderStatusDTO.getId());
        orderStatusService.setStatus(orderStatusDTO.getStatus());
        orderStatusService.setCreatedAt(orderStatusDTO.getCreatedAt());
        orderStatusService.setUpdatedAt(orderStatusDTO.getUpdatedAt());
//        OrderStatus save = orderRepository.save (orderStatusService);
//        return convertEntityToDTO(save);
    return null;
    }

    private OrderStatusDTO convertEntityToDTO(OrderStatus save) {
        OrderStatusDTO orderStatus = new OrderStatusDTO ();
        if(save.getId() != null) orderStatus.setId(save.getId());
        orderStatus.setStatus(save.getStatus());
        orderStatus.setCreatedAt(save.getCreatedAt());
        orderStatus.setUpdatedAt(save.getUpdatedAt());
        return orderStatus;
    }
}
