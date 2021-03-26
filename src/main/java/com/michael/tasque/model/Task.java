package com.michael.tasque.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private boolean completed;

}
