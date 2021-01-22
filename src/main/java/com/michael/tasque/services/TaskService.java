package com.michael.tasque.services;

import com.michael.tasque.dao.TaskDaoImpl;
import com.michael.tasque.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDaoImpl taskDao;

    public String hello() {
        return "Hello";
    }

    // REMINDER: SET COMPLETED TO DEFAULT FALSE IN SQL AND Task Model
    public Task createTask(String name, String body, Boolean completed) {
        Task task = new Task();

        // Task.sets

        return task;
    }

}
