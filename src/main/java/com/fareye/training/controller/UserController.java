package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();

    @GetMapping("/getUser")
    public List<User> getUsers(@RequestParam String name) {
        return users;
    }

    @PostMapping("/createUser")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }
}
