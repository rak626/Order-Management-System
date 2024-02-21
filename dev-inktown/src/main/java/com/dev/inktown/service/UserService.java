package com.dev.inktown.service;


import com.dev.inktown.entity.User;
import com.dev.inktown.model.UserRole;
import com.dev.inktown.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final OrderService orderService;

    public UserService(UserRepository userRepository, OrderService orderService) {
        this.userRepository = userRepository;

        this.orderService = orderService;
    }

    public User getUserById(String userId) {
        Optional<User> result = userRepository.findById(userId);
        return result.orElseGet(User::new);
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public Object getOrdersForUser(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            int role = optionalUser.get().getUserRole();
            if (role == UserRole.CUST.getInternalId()) {
                return getOrdersForCustomer(userId);
            } else {
                return getOrdersForEmployee(userId);
            }
        }
        return optionalUser;
    }

    public Object getOrdersForEmployee(String userId) {
        return orderService.getOrderListForEmployee(userId);
    }

    public Object getOrdersForCustomer(String userId) {
        return orderService.getOrderListForCust(userId);
    }

}
