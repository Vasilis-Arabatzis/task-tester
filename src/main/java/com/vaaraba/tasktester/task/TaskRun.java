package com.vaaraba.tasktester.task;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;

    private String status; // PASS / FAIL

    private String message;

    private LocalDateTime executedAt;

    @PrePersist
    public void prePersist(){
        executedAt = LocalDateTime.now();
    }
}