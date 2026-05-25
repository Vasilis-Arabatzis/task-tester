package com.vaaraba.tasktester.task;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean completed;

    public Task() {}

    public Task(String title) {
        this.title = title;
    }

    public void setTitle(String title) { this.title = title; }

    public void setCompleted(boolean completed) { this.completed = completed; }
}