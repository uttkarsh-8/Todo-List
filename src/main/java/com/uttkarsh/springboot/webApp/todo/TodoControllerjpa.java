package com.uttkarsh.springboot.webApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
public class TodoControllerjpa {

    @Autowired
    private TodoRepository todoRepository;

    // list-todos
    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedinUsername(modelMap);
        List<Todo> todos = todoRepository.findByUsername(username);
        modelMap.addAttribute("todos", todos);

        return "listTodos";
    }

    private String getLoggedinUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "Default Description", LocalDate.now().plusMonths(2), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        } else {
            String username = getLoggedinUsername(modelMap);
            todo.setUsername(username);
            todoRepository.save(todo);

            return "redirect:list-todos";
        }

    }

    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id) {
        // Delete Todo
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodos(@RequestParam int id, ModelMap modelMap) {
        // Update Todo
        Todo todo = todoRepository.findById(id).get();
        modelMap.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodos(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        } else {
            String username = getLoggedinUsername(modelMap);
            todo.setUsername(username);
            todoRepository.save(todo);

            return "redirect:list-todos";
        }
    }
}
