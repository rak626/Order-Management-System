package com.dev.inktown.service;

import com.dev.inktown.entity.OrderUpdateLog;
import com.dev.inktown.repository.OrderUpdateLogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderUpdateLogService {

    @Autowired
    OrderUpdateLogRepository orderUpdateLogRepository;


    @Transactional
    public void saveOrderLog(OrderUpdateLog logObject){
        orderUpdateLogRepository.save(logObject);
    }
}
