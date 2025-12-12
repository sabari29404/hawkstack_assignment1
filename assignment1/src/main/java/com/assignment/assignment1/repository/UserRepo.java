package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {}

