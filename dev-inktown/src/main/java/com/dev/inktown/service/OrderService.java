package com.dev.inktown.service;

import com.dev.inktown.constant.StringConstant;
import com.dev.inktown.entity.Customer;
import com.dev.inktown.entity.Order;
import com.dev.inktown.entity.OrderUpdateLog;
import com.dev.inktown.mapper.CustomObjectMapper;
import com.dev.inktown.model.DisplayStatusResp;
import com.dev.inktown.model.NewOrderRequestDto;
import com.dev.inktown.model.OrderStatus;
import com.dev.inktown.model.UpdateOrderStatusReqDto;
import com.dev.inktown.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements StringConstant {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerService customerService;

    @Autowired
    OrderUpdateLogService orderUpdateLogService;
    public Order getOrderById(String orderId){
        Optional<Order> result = orderRepository.findById(orderId);
        return result.orElseGet(Order::new);
    }

    @Transactional
    public Order createOrder(NewOrderRequestDto orderRequestDto) {
        Order newOrder= CustomObjectMapper.OrderMapperFromNewOrderRequestDto(orderRequestDto);
        newOrder.setUserId(INITIAL_STATUS);
        Customer customer = CustomObjectMapper.CustomerMapperFromNewOrderRequestDto(orderRequestDto);
        //call for save customer
        Customer savedCustomer = customerService.createCustomer(customer);
        newOrder.setCustomerId(savedCustomer.getCustomerId());
        OrderUpdateLog orderUpdateLog = new OrderUpdateLog();
        //saving in order table
        var savedOrder = orderRepository.save(newOrder);
        //saving in updateLogtable
        orderUpdateLog.setOrderId(savedOrder.getOrderId());
        orderUpdateLog.setCurrentOrderStatus(savedOrder.getOrderStatus());
        orderUpdateLog.setUpdatedBy(INITIAL_STATUS);
        orderUpdateLogService.saveOrderLog(orderUpdateLog);
        return savedOrder;
    }

   @Transactional
    public Order updateOrderStatus(UpdateOrderStatusReqDto updateOrderStatusReqDto){
        Optional<Order> prevSavedOrder = orderRepository.findById(updateOrderStatusReqDto.getOrderId());
       System.out.println("prev123"+ prevSavedOrder.toString());
        if(prevSavedOrder.isPresent()){
            Order order = prevSavedOrder.get();
            order.setOrderStatus(updateOrderStatusReqDto.getStatus());
            order.setUserId(updateOrderStatusReqDto.getUserId());
            Order currSavedOrder =  orderRepository.save(order);
            OrderUpdateLog orderUpdateLog = CustomObjectMapper.OrderUpdateLogFromOrder(currSavedOrder);
            orderUpdateLogService.saveOrderLog(orderUpdateLog);
            return currSavedOrder;

        }
        return new Order();
    }

    public List<DisplayStatusResp> getDisplayStatusList(){
        List<DisplayStatusResp> res = new ArrayList<>();
        for(OrderStatus os:OrderStatus.values()){
            DisplayStatusResp obj = new DisplayStatusResp();
            obj.setOrderStatus(os.getInternalId());
            switch (os){
                case DESIGN_PENDING -> obj.setDisplayValue("In Design queue");
                case DESIGN_PROGRESS -> obj.setDisplayValue("Design is in progress");
                case PRINT_PENDING -> obj.setDisplayValue("In Printing queue");
                case PRINT_PROGRESS -> obj.setDisplayValue("Printing in progress");
                case PACKAGING_PENDING -> obj.setDisplayValue("In Packaging queue");
                case PACKAGING_PROGRESS -> obj.setDisplayValue("Packaging in progress");
                case READY_FOR_DELIVERY -> obj.setDisplayValue("Waiting for delivery");
                case DISPATCHED -> obj.setDisplayValue("Delivery in progress");
                case DELIVERED -> obj.setDisplayValue("Delivery completed");
            }
            res.add(obj);
        }
        return res;
    }
}
