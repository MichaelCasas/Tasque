package com.michael.tasque.dao;

import com.michael.tasque.model.Task;

import java.util.List;

public interface TaskDao {
    Task create(final Task task);
    List find();
    Task findOne(int id);
}


