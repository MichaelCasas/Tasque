package com.michael.tasque.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.michael.tasque.model.Task;
import com.michael.tasque.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    // Create a task.
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task createTask(@JsonProperty String title, @JsonProperty String body) {
        Task task = this.taskService.createTask(title, body);
        return task;
    }

    // Read all tasks.
//    @GetMapping
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<Task> getTasks() {
//       return this.taskService.getTasks();
//    }

//    @GetMapping(path = "/{id}")
//    public Task getTask(int id) {
//        return this.taskService.getTask();
//    }
}
