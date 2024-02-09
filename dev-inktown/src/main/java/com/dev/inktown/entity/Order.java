package com.dev.inktown.entity;

import com.dev.inktown.model.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @UuidGenerator
    @Column(unique = true, nullable = false)
    String orderId;

    @Column(nullable = false)
    String orderName;

    @Column(columnDefinition = "Text")
    String orderDesc;

    @Column(nullable = false)
    Long squareFeet;

    @Column(nullable = false)
    OrderStatus orderStatus;

    @Column
    Boolean isUrgent;

    @Column(nullable = false)
    String customerId;

    @Column
    String userId;

    @CreationTimestamp
    LocalDateTime createdAt;


    @UpdateTimestamp
    LocalDateTime lastModifiedAt;

}
