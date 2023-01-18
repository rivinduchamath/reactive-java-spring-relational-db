package com.cloudofgoods.order.entity.pk;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AcceptedSubOrderReservationUnitPK implements Serializable {
    @Column(name="accepted_sub_order_id")
    private Long acceptedSubOrderId;

    @Column(name="reservation_unit_id")
    private Long reservationUnitId;














}
