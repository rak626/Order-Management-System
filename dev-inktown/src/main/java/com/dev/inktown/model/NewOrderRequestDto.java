package com.dev.inktown.model;

import com.dev.inktown.entity.Customer;
import com.dev.inktown.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewOrderRequestDto {
    private String customerName;
    private String customerPhoneNo;
    private String customerEmail;
    private String orderDesc;
    private Long squareFeet;
    private OrderStatus orderStatus;
    private String orderName;
    private Boolean isUrgent;
}
