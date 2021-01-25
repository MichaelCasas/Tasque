package com.michael.tasque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {

    private int id;
    private String title;
    private String body;
    private boolean completed; 

    public Task() {
        this.completed = false;
    }

}
