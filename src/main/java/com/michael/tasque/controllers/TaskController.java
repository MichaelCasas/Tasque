package com.michael.tasque.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.michael.tasque.entities.Task;
import com.michael.tasque.entities.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("api/v1/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create a task.
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Task> create(
            @JsonProperty String title,
            @JsonProperty String body
    ) throws URISyntaxException {

        if ((title == null) || (body == null)){
            return ResponseEntity.badRequest().build();
        }

        Task task = new Task();

        task.setTitle(title);
        task.setBody(body);

        this.taskRepository.save(task);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();

        return ResponseEntity.created(uri).body(task);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Task>> getTasks() {

        List<Task> tasks = (List<Task>) this.taskRepository.findAll();

        return ResponseEntity.ok().body(tasks);

    }

//    @GetMapping(path = "/{id}")
//    public Task getTask(int id) {
//        return this.taskService.getTask();
//    }
}
