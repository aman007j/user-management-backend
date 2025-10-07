package com.atomtech.usermanagement.service;

import com.atomtech.usermanagement.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User createUser(String firstName, String lastName) {
        Long id = idCounter.getAndIncrement();
        User newUser = new User(id, firstName, lastName);
        users.add(newUser);
        return newUser;
    }
}
