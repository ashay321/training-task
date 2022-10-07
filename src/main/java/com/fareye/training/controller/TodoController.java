package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TodoController {
    HashMap<Integer, Todo> todos = new HashMap<Integer, Todo>();
    int todoId;

    @GetMapping("/todos")
    public HashMap<Integer, Todo> getTasks() {
        return todos;
    }

    @PostMapping("/todos")
    public HashMap<Integer, Todo> addTask(@RequestBody Todo task) {
        task.setId(todoId);
        todos.put(task.getId(), task);
        todoId++;

        return todos;
    }

    @PutMapping("/todos/{id}")
    public Todo updateTask(@RequestBody Todo task, @PathVariable("id") int id) throws Exception {
        // id :- taskId to be updated
        if(!todos.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        task.setId(id);
        todos.put(id, task);
        return todos.get(id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTask(@PathVariable("id") int id) throws Exception {

        if(!todos.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        todos.remove(id);
    }


}
