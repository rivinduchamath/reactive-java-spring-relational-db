package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accepted_sub_order")
public class AcceptedSubOrder implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accepted_sub_order_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @Column(name = "accepted_merchant_id")
    private Long acceptedMerchantId;
    @Column(name = "accepted_date")
    private String acceptedDate;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name = "delivery_date_time")
    private String deliveryDateTime;
    @Column(name = "asset")
    private String asset;
    @Column(name = "notes", columnDefinition = "text")
    private String notes;
    @Column(name = "driver_notes")
    private String driverNotes;
    @Column(name = "delivery_type")
    private String deliveryType;
    @Column(name = "current_tracking_status")
    private String currentTrackingStatus;
    @OneToMany(mappedBy = "acceptedSubOrder")
    Set<AcceptedSubOrderReservationUnit> acceptedSubOrderReservationUnitSet = new HashSet<>();
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "sub_order_status_id", referencedColumnName = "id")
    private SubOrderStatus subOrderStatus;
}
