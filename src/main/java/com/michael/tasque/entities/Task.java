package com.michael.tasque.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
    private Long id;

    // TODO:
    /*
        ADD VALIDATION ON ENTITY AND CONTROLLER
        DEFAULT completed TO FALSE
     */
    private String title;
    private String body;
    private Boolean completed;

}
