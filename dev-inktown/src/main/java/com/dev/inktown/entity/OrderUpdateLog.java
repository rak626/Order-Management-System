package com.dev.inktown.entity;

import com.dev.inktown.model.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_update_log")
public class OrderUpdateLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    String id;
    String orderID;

    LocalDateTime newAt;
    LocalDateTime assignedAt;
    LocalDateTime inProgressAt;
    LocalDateTime  completedAt;
    LocalDateTime  declinedAt;
    LocalDateTime  reviewedAt;
    LocalDateTime  deliveredAt;


}
