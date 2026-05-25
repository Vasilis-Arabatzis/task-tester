package com.vaaraba.tasktester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TaskTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTesterApplication.class, args);
	}

}
