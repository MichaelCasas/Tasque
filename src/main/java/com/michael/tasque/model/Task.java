package com.michael.tasque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private boolean completed; 

    public Task(String title, String body) {
        this.title = title;
        this.body = body;
        this.completed = false;
    }

    public Task() {
        this.completed = false;
    }

}
