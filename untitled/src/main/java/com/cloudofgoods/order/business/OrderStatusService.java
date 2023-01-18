package com.cloudofgoods.order.business;

import com.cloudofgoods.order.dto.OrderStatusDTO;

public interface OrderStatusService {
    OrderStatusDTO saveOrderStatus(OrderStatusDTO orderStatusDTO);
}
