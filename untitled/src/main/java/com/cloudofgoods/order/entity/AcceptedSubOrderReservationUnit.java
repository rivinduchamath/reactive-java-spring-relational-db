package com.cloudofgoods.order.entity;


import com.cloudofgoods.order.entity.pk.AcceptedSubOrderReservationUnitPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accepted_sub_order_reservation_unit")
public class AcceptedSubOrderReservationUnit implements SuperEntity {
    @EmbeddedId
    private AcceptedSubOrderReservationUnitPK acceptedSubOrderReservationUnitPK;
    @Column(name = "accepted_date")
    private String acceptedDate;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(insertable = false, updatable = false, referencedColumnName = "id", name = "accepted_sub_order_id")
    private AcceptedSubOrder acceptedSubOrder;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(insertable = false, updatable = false, referencedColumnName = "id", name = "reservation_unit_id")
    private ReservationUnit reservationUnit;

}
