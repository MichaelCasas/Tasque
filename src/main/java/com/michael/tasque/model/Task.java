package com.michael.tasque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
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
