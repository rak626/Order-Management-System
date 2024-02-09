package com.dev.inktown.mapper;

import com.dev.inktown.entity.Customer;
import com.dev.inktown.entity.Order;
import com.dev.inktown.entity.OrderUpdateLog;
import com.dev.inktown.model.NewOrderRequestDto;

public class CustomObjectMapper {

      public static Customer CustomerMapperFromNewOrderRequestDto(NewOrderRequestDto requestDto){
          Customer cust = new Customer();
          cust.setCustomerName(requestDto.getCustomerName());
          cust.setPhoneNo(requestDto.getCustomerPhoneNo());
          if(requestDto.getCustomerEmail()!=null){
              cust.setCustomerEmail(requestDto.getCustomerEmail());
          }
          return cust;
      }
      public static Order OrderMapperFromNewOrderRequestDto(NewOrderRequestDto reqDto){
          Order order = new Order();
          order.setSquareFeet(reqDto.getSquareFeet());
          order.setOrderStatus(reqDto.getOrderStatus());
          if(reqDto.getOrderDesc()!=null){
              order.setOrderDesc(reqDto.getOrderDesc());
          }
          order.setOrderName(reqDto.getOrderName());
          order.setIsUrgent(reqDto.getIsUrgent());
          return order;
      }
      public static OrderUpdateLog OrderUpdateLogFromOrder(Order order){
          OrderUpdateLog orderUpdateLog = new OrderUpdateLog();
          orderUpdateLog.setOrderId((order.getOrderId()));
          orderUpdateLog.setUpdatedBy(order.getUserId());
          orderUpdateLog.setCurrentOrderStatus(order.getOrderStatus());
          return orderUpdateLog;
      }
}
