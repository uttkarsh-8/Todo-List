package com.uttkarsh.springboot.webApp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// We have to store it in a database (Mysql)
// Static list of todos => Database(H2, Mysql)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targDate;
    private boolean done;

}
// buisness mode, idea explain breif , stakeholder