package com.dev.inktown.mapper;

import com.dev.inktown.entity.Order;
import com.dev.inktown.model.OrderOutputModel;

public class OrderOutputModelMapper {

    public static OrderOutputModel orderToOrderOutputModelMapper(Order order) {
        return OrderOutputModel.builder()
                .orderId(order.getOrderId())
                .orderName(order.getOrderName())
                .orderDesc(order.getOrderDesc())
                .orderStatus(order.getOrderStatus().getInternalId())
                .assignedTo(order.getUserId())
                .squareFeet(order.getSquareFeet())
                .createdAt(order.getCreatedAt())
                .isUrgent(order.getIsUrgent())
                .lastModifiedAt(order.getLastModifiedAt())
                .customerId(order.getCustomerId())
                .build();
    }
}
