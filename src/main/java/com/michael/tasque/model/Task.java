package com.michael.tasque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Task {

    private int id;
    private String name;
    private String body;
    private boolean completed;

}
