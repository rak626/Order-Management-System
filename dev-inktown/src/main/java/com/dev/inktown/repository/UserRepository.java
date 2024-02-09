package com.dev.inktown.repository;

import com.dev.inktown.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
