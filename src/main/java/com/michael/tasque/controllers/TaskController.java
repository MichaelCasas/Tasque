package com.michael.tasque.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.michael.tasque.model.Task;
import com.michael.tasque.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Object> createTask( @RequestBody Task task ) {

    }
    @GetMapping(path = "/hello")
    public String hello() {
        return this.taskService.hello();
    }
}
