package com.todolist.todolist.controller;


import com.todolist.todolist.model.TodoList;
import com.todolist.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TodoController {


    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/todoList")
    public ResponseEntity<?> saveTodo(@RequestBody TodoList todoList) {
        TodoList todoList1 = todoRepository.save(todoList);
        return new ResponseEntity<>(todoList1, HttpStatus.OK);
    }

    @GetMapping("/todoList")
    public ResponseEntity<?> fetchTodo() {
        List<TodoList> db = todoRepository.findAll();
        return new ResponseEntity<>(db, HttpStatus.OK);
    }

    @DeleteMapping("/todoList")
    public ResponseEntity<?> deleteTodo(@RequestBody TodoList todoList) {
//        TodoList todo = todoRepository.findFirstById(todoList.getId());
        todoRepository.deleteById(todoList.getId());

        Map<String, String> response = new HashMap<>();
        response.put("message", "todo deleted successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
