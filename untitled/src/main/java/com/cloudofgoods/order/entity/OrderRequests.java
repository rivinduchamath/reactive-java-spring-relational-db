package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order_requests")
public class OrderRequests implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_requests_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "borrower_id")
    private Long borrowerId;
    @Column(name = "date_from")
    private String dateFrom;
    @Column(name = "date_to")
    private String dateTo;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    private String status;
    @Column(name = "warning_code")
    private String warningCode;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "delivery_charge")
    private double deliveryCharge;
    @Column(name = "other_fee")
    private double otherFee;
    private double discount;
    @Column(name = "next_day_morning_pickup_fee")
    private double nextDayMorningPickupFee;
    @Column(name = "damage_waiver_fee")
    private double damageWaiverFee;
    @Column(name = "drop_of_address", columnDefinition = "text")
    private String dropOfAddress;

    @Column(name = "special_note", columnDefinition = "text")
    private String specialNote;
    @Column(name = "delivery_area_id", columnDefinition = "text")
    private String deliveryAreaId;
    @Column(name = "pickup_address", columnDefinition = "text")
    private String pickupAddress;
    @Column(name = "city_id", columnDefinition = "text")
    private String cityId;
    @Column(name = "warning_date_time", columnDefinition = "text")
    private String warningDateTime;
    @Column(name = "cancel_date_time", columnDefinition = "text")
    private String cancelDateTime;


}
