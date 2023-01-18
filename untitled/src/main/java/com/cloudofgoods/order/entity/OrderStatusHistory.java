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
@Table(name = "`order_status_history`")
public class OrderStatusHistory implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_status_history_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "reservation_unit_id", referencedColumnName = "id")
    private ReservationUnit reservationUnit;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "new_order_status_id", referencedColumnName = "id")
    private OrderStatus orderStatus;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "new_order_status_from_id", referencedColumnName = "id")
    private OrderStatus orderStatusFromId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "other_data", columnDefinition = "text")
    private String otherData;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

}
