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
public class OrderDTO {
    Set <ReservationUnitDTO> reservationUnitSetDTO = new HashSet <> ();
    private Long id;
    private Long userId;
    private Long shoppingCartId;
    private boolean isFullOrderAccepted;
    private String orderPlacedDate;
    private boolean isAutoCancelled;
    private double totalHours;
    private double chargingStatus;
    private double totalAmount;
    private double otherFee;
    private String otherFeeMemo;
    private double nextDayMorningPickupFee;
    private double discount;
    private double deliveryTypeStatus;
    private double paymentType;
    private double paymentDate;
    private double createdAt;
    private double updatedAt;
    private String requestedVia;
    private String driverNotes;
    private String swapReason;

//    Set <AcceptedSubOrder> acceptedSubOrders = new HashSet <> ();
}
