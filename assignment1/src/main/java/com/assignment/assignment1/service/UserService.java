package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.User;
import com.assignment.assignment1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<User> getUsers() {
        return repo.findAll();
    }
}

