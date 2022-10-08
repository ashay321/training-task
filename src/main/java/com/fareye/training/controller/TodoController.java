package com.fareye.training.controller;
import com.fareye.training.model.Todo;

import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.lang.annotation.*;
import java.util.*;

@RestController
public class TodoController {
    private static HashMap<Integer, Todo> todos = new HashMap<Integer, Todo>();
    Set<String> titles = new HashSet<>();
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
    public void deleteTask(@PathVariable("id") int id) throws Exception {

        if(!todos.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        titles.remove(todos.get(id).getTitle());
        todos.remove(id);
    }

    @Target( { ElementType.FIELD, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Constraint(validatedBy = TitleValidator.class)
    public @interface DuplicateTitle {
        //error message
        public String message() default "Duplicate title!! Please change the title.";
        //represents group of constraints
        public Class<?>[] groups() default {};
        //represents additional information about annotation
        public Class<? extends Payload>[] payload() default {};
    }

    public class TitleValidator implements ConstraintValidator<DuplicateTitle, String>
    {
        public boolean isValid(String title, ConstraintValidatorContext cxt) {
            return ! titles.contains(title);
        }
    }

}
