package com.vaaraba.tasktester.task;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobRepository repository;

    public JobController(JobRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{taskId}")
    public Job createJob(@PathVariable Long taskId) {

        Job job = new Job();
        job.setTaskId(taskId);
        job.setStatus("PENDING");

        return repository.save(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return repository.findAll();
    }
}