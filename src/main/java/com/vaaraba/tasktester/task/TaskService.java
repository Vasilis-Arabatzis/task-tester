package com.vaaraba.tasktester.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task create(String title) {
        return repository.save(new Task(title));
    }

    public Task getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Task complete(Long id) {
        Task task = getById(id);
        task.setCompleted(true);
        return repository.save(task);
    }
}