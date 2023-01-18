package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class OrderStatusHistoryDTO {
    private Long id;

//    private ReservationUnit reservationUnit;
    private Long orderStatus;
    private Long orderStatusFromId;
    private Long userId;
    private String otherData;

    private String createdAt;

    private String updatedAt;
}
