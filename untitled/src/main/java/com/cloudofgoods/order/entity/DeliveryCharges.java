package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "`delivery_charges`")
public class DeliveryCharges implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_charges_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "is_same_day")
    private boolean isSameDay;
    @Column(name = "is_standard_time")
    private boolean isStandardTime;
    @Column(name = "track_Type")
    private String trackType;
    @Column(name = "delivery_fee")
    private double deliveryFee;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private DeliveryArea locationId;
}
