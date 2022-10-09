package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }
}
