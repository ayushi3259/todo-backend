package com.todolist.todolist.repository;

import com.todolist.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList, Integer> {
    TodoList findFirstById(Integer id);
}
