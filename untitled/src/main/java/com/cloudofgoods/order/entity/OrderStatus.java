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
@Table(name = "`order_status`")
public class OrderStatus implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_status_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    private String status;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "orderStatus")
    Set <ReservationUnit> reservationUnitSet = new HashSet <> ();
    @OneToMany(mappedBy = "orderStatus")
    Set <OrderStatusHistory> orderStatusHistories;
    @OneToMany(mappedBy = "orderStatusFromId")
    Set <OrderStatusHistory> orderStatusFromId;

    public OrderStatus(Long orderStatusId) {
        this.id = orderStatusId;
    }
}
