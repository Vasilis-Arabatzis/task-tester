package com.vaaraba.tasktester.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")

public class TaskRunController {

    private final TaskRunService service;

    public TaskRunController(TaskRunService service) {
        this.service = service;
    }

    @GetMapping("/runs")
    public List<TaskRun> getAll() {
        return service.getAllRuns();
    }

    @PostMapping("/run/{taskId}")
    public TaskRun runTask(@PathVariable Long taskId) {
        System.out.println("TASK ID RECEIVED: " + taskId);
        return service.runTask(taskId);
    }
}