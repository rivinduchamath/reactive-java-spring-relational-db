package com.cloudofgoods.order.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "`delivery_area`")
public class DeliveryArea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_area_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "is_airport")
    private boolean isAirport;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "distance")
    private double distance;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name = "current_track_type")
    private String currentTrackType;
    @Column(name = "current_delivery_fee")
    private String currentDeliveryFee;
    @OneToMany(mappedBy = "deliveryArea")
    Set <ReservationUnit> reservationUnitSet = new HashSet <> ();
    @OneToMany(mappedBy = "locationId")
    Set <DeliveryCharges> deliveryCharges = new HashSet <> ();

    public DeliveryArea(Long deliveryAreaId) {
        this.id = deliveryAreaId;
    }
}
