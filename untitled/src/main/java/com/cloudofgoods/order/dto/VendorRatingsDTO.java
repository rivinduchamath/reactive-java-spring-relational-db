package com.cloudofgoods.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class VendorRatingsDTO {
    private Long id;
    private String raterType;
    private double starRatingItem;
    private double starRatingMerchant;
    private String status;
    private String userRatedAs;

    private String createdAt;

    private String updatedAt;

    private Long raterId;

    private Long reservationUnitId;
}
