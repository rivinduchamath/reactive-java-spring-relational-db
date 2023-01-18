package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class DeliveryChargesDTO {
    private Long id;

    private boolean isSameDay;

    private boolean isStandardTime;

    private String trackType;

    private double deliveryFee;

    private String createdAt;

    private String updatedAt;

    private DeliveryAreaDTO deliveryAreaDTO;
}
