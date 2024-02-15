package com.dev.inktown.repository;

import com.dev.inktown.entity.Order;
import com.dev.inktown.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByAssignedTo(String userId);
    List<Order> findByCreatedBy(String userId);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

}
