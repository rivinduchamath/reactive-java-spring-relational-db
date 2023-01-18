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
@Table(name = "`order_delivery_locations`")
public class OrderDeliveryLocations implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_delivery_locations_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "delivery_place_id")
    private String deliveryPlaceId;
    @Column(name = "pickup_place_id")
    private String pickupPlaceId;
    @Column(name = "is_airport_pickup")
    private String isAirportPickup;
    @Column(name = "is_airport_drop_off")
    private String isAirportDropOff;
    @Column(name = "delivery_location_type")
    private String deliveryLocationType;
    @Column(name = "pickup_location_type")
    private String pickupLocationType;
    @Column(name = "blacklist_drop_off_type")
    private String blacklistDropOffType;
    @Column(name = "blacklist_pickup_type")
    private String blacklistPickupType;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;


}
