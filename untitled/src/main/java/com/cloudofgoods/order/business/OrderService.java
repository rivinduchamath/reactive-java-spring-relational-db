package com.cloudofgoods.order.business;

import com.cloudofgoods.order.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
}
