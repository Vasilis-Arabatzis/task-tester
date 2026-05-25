package com.vaaraba.tasktester.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.vaaraba.tasktester.task.TaskRun;
import com.vaaraba.tasktester.task.TaskRunRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Task create(@RequestBody String title) {
        return service.create(title);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/complete")
    public Task complete(@PathVariable Long id) {
        return service.complete(id);
    }
}