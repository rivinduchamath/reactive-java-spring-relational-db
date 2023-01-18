package com.cloudofgoods.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vendor_ratings")
@Entity
public class VendorRatings implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_ratings_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rater_type")
    private String raterType;
    @Column(name = "star_rating_item")
    private double starRatingItem;
    @Column(name = "star_rating_merchant")
    private double starRatingMerchant;
    private String status;
    @Column(name = "user_rated_as")
    private String userRatedAs;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name = "rater_id")
    private Long raterId;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "reservation_unit_id", referencedColumnName = "id")
    private ReservationUnit reservationUnit;
}
