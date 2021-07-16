package com.michael.tasque.models;

import lombok.*;

import java.sql.Timestamp;

import javax.persistence.*;
// import javax.validation.constraints.Max;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    public Task(String title, String body, Boolean completed) {
        this.title = title;
        this.body = body;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Boolean completed;

    @Column
    private Timestamp created_at;

    @Column
    private Timestamp updated_on;
}
