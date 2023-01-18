package com.cloudofgoods.order.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vendor_feedback")
public class VendorFeedback implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_feedback_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "reservation_unit_id", referencedColumnName = "id")
    private ReservationUnit reservationUnit;

    @Column(name = "feedback" , columnDefinition = "text")
    private String feedback;
    private boolean damaged;
    @Column(columnDefinition = "text")
    private String reason;
    @Column( name = "merchant_feedback", columnDefinition = "text")
    private String merchantFeedback;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name = "rater_id")
    private Long raterId;

}
