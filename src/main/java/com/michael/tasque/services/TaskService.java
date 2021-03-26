package com.michael.tasque.services;

import com.michael.tasque.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public Task createTask(String title, String body) {

        Task task = new Task();
        task.setTitle(title);
        task.setBody(body);

        return task;
    }
}
