package com.dev.inktown.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class OrderOutputModel {
    String orderId;
    String orderName;
    String orderDesc;
    Long squareFeet;
    int orderStatus;
    Boolean isUrgent;
    String customerId;
    String assignedTo;
    LocalDateTime createdAt;
    LocalDateTime lastModifiedAt;
}
