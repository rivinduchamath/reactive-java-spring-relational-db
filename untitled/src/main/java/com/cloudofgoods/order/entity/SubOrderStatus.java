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
@Table(name = "subOrder_status")
public class SubOrderStatus implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subOrder_status_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @OneToMany(mappedBy = "subOrderStatus")
    Set <AcceptedSubOrder> acceptedSubOrders = new HashSet <> ();
}
