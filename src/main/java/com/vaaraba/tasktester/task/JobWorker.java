package com.vaaraba.tasktester.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobWorker {

    private final JobRepository jobRepository;
    private final TaskRunService taskRunService;

    public JobWorker(JobRepository jobRepository, TaskRunService taskRunService) {
        this.jobRepository = jobRepository;
        this.taskRunService = taskRunService;
    }

    @Scheduled(fixedDelay = 3000) // every 3 seconds
    public void processJobs() {

        List<Job> jobs = jobRepository.findByStatus("PENDING");

        for (Job job : jobs) {

            try {
                taskRunService.runTask(job.getTaskId());

                job.setStatus("DONE");

            } catch (Exception e) {
                job.setStatus("FAILED");
            }

            job.setProcessedAt(LocalDateTime.now());
            jobRepository.save(job);
        }
    }
}