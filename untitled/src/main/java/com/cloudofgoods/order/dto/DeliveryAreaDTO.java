package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class DeliveryAreaDTO {
    private Long id;

    private Long cityId;

    private String locationName;

    private String description;

    private boolean isAirport;

    private boolean isActive;

    private double distance;

    private String createdAt;

    private String updatedAt;

    private String currentTrackType;
    private String currentDeliveryFee;
    Set <DeliveryChargesDTO> deliveryCharges = new HashSet <> ();
}
