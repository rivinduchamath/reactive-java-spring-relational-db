package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class OrderDeliveryLocationsDTO {
    private Long id;

    private String zipCode;

    private String contactNumber;

    private String deliveryAddress;

    private String deliveryPlaceId;

    private String pickupPlaceId;

    private String isAirportPickup;

    private String isAirportDropOff;

    private String deliveryLocationType;

    private String pickupLocationType;

    private String blacklistDropOffType;

    private String blacklistPickupType;

    private String createdAt;

    private String updatedAt;
}
