package com.uttkarsh.springboot.webApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

    private static int todosCount = 0;

    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(++todosCount, "uttu", "Java for backend", LocalDate.now().plusDays(69), false));
        todos.add(new Todo(++todosCount, "uttkarsh", "JavaScript for frontend", LocalDate.now().plusDays(5), false));
        todos.add(new Todo(++todosCount, "srivastava", "AWS for cloud services", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todos -> todos.getUsername().equalsIgnoreCase(username);

        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate tardDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, tardDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todos -> todos.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todos -> todos.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
