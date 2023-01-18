package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "`order`")
public class Order implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;
    @Column(name = "is_full_order_accepted")
    private boolean isFullOrderAccepted;
    @Column(name = "order_placed_date")
    private String orderPlacedDate;
    @Column(name = "is_auto_cancelled")
    private boolean isAutoCancelled;
    @Column(name = "total_hours")
    private double totalHours;
    @Column(name = "charging_status")
    private double chargingStatus;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "other_fee")
    private double otherFee;
    @Column(name = "other_fee_memo")
    private String otherFeeMemo;
    @Column(name = "next_day_morning_pickup_fee")
    private double nextDayMorningPickupFee;
    @Column(name = "discount")
    private double discount;
    @Column(name = "delivery_type_status")
    private double deliveryTypeStatus;
    @Column(name = "payment_type")
    private double paymentType;
    @Column(name = "payment_date")
    private double paymentDate;
    @Column(name = "created_at")
    private double createdAt;
    @Column(name = "updated_at")
    private double updatedAt;
    @Column(name = "requested_via")
    private String requestedVia;
    @Column(name = "driver_notes")
    private String driverNotes;
    @Column(name = "swap_reason")
    private String swapReason;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    Set <ReservationUnit> reservationUnitSet = new HashSet <> ();
    @OneToMany(mappedBy = "order")
    Set <AcceptedSubOrder> acceptedSubOrders = new HashSet <> ();


}
