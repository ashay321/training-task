package com.fareye.training.controller;
import com.fareye.training.model.Todo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.util.*;

@RestController
public class TodoController {


    private static HashMap<Integer, Todo> todos = new HashMap<Integer, Todo>();
    public static Set<String> titles = new HashSet<>();
    int todoId;

    @GetMapping("/todos")
    public HashMap<Integer, Todo> getTasks() {
        return todos;
    }

    @PostMapping("/todos")
    public HashMap<Integer, Todo> addTask(@Valid @RequestBody Todo task) {
        task.setId(todoId);
        todos.put(task.getId(), task);
        titles.add(task.getTitle());

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
        titles.add(task.getTitle());

        return todos.get(id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTask(@PathVariable("id") int id, HttpServletResponse response) throws Exception {

        if(!todos.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);

        titles.remove(todos.get(id).getTitle());
        todos.remove(id);
    }

}
