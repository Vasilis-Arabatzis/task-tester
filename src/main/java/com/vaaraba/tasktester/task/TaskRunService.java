package com.vaaraba.tasktester.task;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRunService {

    private final TaskRunRepository repository;
    private final TaskRepository taskRepository;

    public TaskRunService(TaskRunRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }

    public TaskRun runTask(Long taskId) {


        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new RuntimeException("Task not found: " + taskId));
        TaskRun run = new TaskRun();
        run.setTaskId(taskId);


        boolean success = executeTask(taskId);

        run.setStatus(success ? "PASS" : "FAIL");
        run.setMessage(success
                ? "Task executed successfully"
                : "Task failed logic check");

        return repository.save(run);
    }

    private boolean executeTask(Long taskId) {return taskId % 2 == 0;}

    public List<TaskRun> getAllRuns() {
        return repository.findAll();
    }
}