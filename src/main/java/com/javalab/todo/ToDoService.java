package com.javalab.todo;

import java.util.List;

public interface ToDoService {
    List<String> getTodos(String user);

    void deleteTodo(String todo);

    void deleteAllTodos();
}
