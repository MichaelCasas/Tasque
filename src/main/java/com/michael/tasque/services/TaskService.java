package com.michael.tasque.services;

import com.michael.tasque.dao.TaskDaoImpl;
import com.michael.tasque.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDaoImpl taskDao;

    // REMINDER: SET COMPLETED TO DEFAULT FALSE IN SQL AND Task Model
    public Task createTask(String title, String body) {

        // task initialization from the server
        Task unpersistedTask = new Task();
        unpersistedTask.setTitle(title);
        unpersistedTask.setBody(body);

        // task persistance with postgresql and our TaskDao implementation class.
        Task persistedTask = this.taskDao.create(unpersistedTask);

        return persistedTask;
    }

    public List<Task> getTasks() {
        return this.taskDao.find();
    }

}
