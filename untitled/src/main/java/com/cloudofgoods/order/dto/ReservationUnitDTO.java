package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class ReservationUnitDTO {
    private Long id;

    private Long unitId;
    private double discount;

    private Long shoppingCartActualCatalogItemClusterId;

    private Long shoppingCartStockId;

    private Long orderStatusId;

    private Long deliveryWindowId;

    private String dateFrom;

    private String dateTo;

    private String purchasedAt;

    private double quantity;

    private double totalUnitAmount;

    private double rentPerDayFee;

    private double deliveryCharge;

    private String priceCache;

    private String invoiceNumber;

    private String deliveryTime;

    private String pickupTime;

    private String specialInstructions;

    private String adminNotes;

    private Long deliveryAreaId;


    Set <OrderStatusHistoryDTO> orderStatusHistoriesDTO;

    private String createdAt;
    private String updatedAt;


    private OrderDeliveryLocationsDTO orderDeliveryLocationsDTO;


}
