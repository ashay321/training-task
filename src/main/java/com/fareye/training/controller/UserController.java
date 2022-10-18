package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import com.fareye.training.model.User;
import com.fareye.training.services.GithubApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
//@RequestMapping("/users")
public class UserController {
//
//    @Autowired
//    public RestTemplate restTemplate;

    @Autowired
    private GithubApi githubApi;

//    List<User> users = new ArrayList<>();
    private static HashMap<Integer, User> users = new HashMap<Integer, User>();
    int userId;


    //    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/users")
    public HashMap<Integer, User>  getUsers() {
        return users;
    }

    @PostMapping("/users")
    public HashMap<Integer, User>  createUser(@Valid @RequestBody User user) {

        String userAvatar = githubApi.getUserAvatar("null");
        user.setUserId(userId);
        users.put(userId, user);
        userId++;

        return users;
    }


    @PutMapping("/users/{id}")
    public User updateTask(@RequestBody User user, @PathVariable("id") int id) throws Exception {
        // id :- userId to be updated
        if(!users.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        user.setUserId(id);
        users.put(id, user);
//        titles.add(task.getTitle());

        return users.get(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteTask(@PathVariable("id") int id, HttpServletResponse response) throws Exception {

        if(!users.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);

//        titles.remove(todos.get(id).getTitle());
        users.remove(id);
    }
}
