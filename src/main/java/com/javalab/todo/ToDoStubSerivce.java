package com.javalab.todo;

import java.util.Arrays;
import java.util.List;

public class ToDoStubSerivce implements ToDoService {
    public List<String> getTodos(String user) {
        return Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use Hibernate ", " Use Spring MVC ");
    }

    public void deleteTodo(String todo) {

    }

    public void deleteAllTodos() {

    }
}
