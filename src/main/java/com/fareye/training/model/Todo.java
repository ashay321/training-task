package com.fareye.training.model;

import com.fareye.training.helper.DuplicateTitle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Todo {

    private int id;
    @DuplicateTitle()
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private LocalDateTime modifiedAt;
    private String status;
    private int userId;

    public Todo(String title, String body, String deadline, int userId) {
        this.title = title;
        this.body = body;
        this.deadline = LocalDateTime.parse(deadline);
        this.createdAt = LocalDateTime.now();
        this.status = "Pending";
        this.userId = userId;
    }

}
