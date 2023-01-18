package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reservation_unit")
public class ReservationUnit implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "reservation_unit_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "unit_id")
    private Long unitId;
    private double discount;
    @Column(name = "shopping_cart_actual_catalog_item_cluster_id")
    private Long shoppingCartActualCatalogItemClusterId;
    @Column(name = "shopping_cart_stock_id")
    private Long shoppingCartStockId;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "current_order_status_id", referencedColumnName = "id")
    private OrderStatus orderStatus;
    @Column(name = "delivery_window_id")
    private Long deliveryWindowId;
    @Column(name = "date_from")
    private String dateFrom;
    @Column(name = "date_to")
    private String dateTo;
    @Column(name = "purchased_at")
    private String purchasedAt;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "total_unit_amount")
    private double totalUnitAmount;
    @Column(name = "rent_per_day_fee")
    private double rentPerDayFee;
    @Column(name = "delivery_charge")
    private double deliveryCharge;
    @Column(name = "price_cache")
    private String priceCache;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "delivery_time")
    private String deliveryTime;
    @Column(name = "pickup_time")
    private String pickupTime;
    @Column(name = "special_instructions")
    private String specialInstructions;
    @Column(name = "admin_notes")
    private String adminNotes;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "delivery_area_id", referencedColumnName = "id")
    private DeliveryArea deliveryArea;
    @OneToMany(mappedBy = "reservationUnit")
    Set <AcceptedSubOrderReservationUnit> acceptedSubOrderReservationUnitSet;
    @OneToMany(mappedBy = "reservationUnit", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set <OrderStatusHistory> orderStatusHistories;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "order_delivery_locations_id")
    private OrderDeliveryLocations orderDeliveryLocations;
    @OneToMany(mappedBy = "reservationUnit")
    Set <VendorRatings> vendorRatings;


}
