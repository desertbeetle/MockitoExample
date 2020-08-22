package com.javalab.todo;

import java.util.ArrayList;
import java.util.List;

// ToDoBusiness is a SUT (system under test)
// ToDoService is a Dependency (as ToDoBusiness is dependent on it)
public class ToDoBusiness {

    ToDoService toDoService;

    public ToDoBusiness(ToDoService service) {
        this.toDoService = service;
    }

    public List<String> getToDosForSpring(String user) {
        List<String> retList = new ArrayList<String>();
       List<String> toDos = toDoService.getTodos(user);
       for (String toDo : toDos) {
           if (toDo.contains("Spring")) {
               retList.add(toDo);
           }
       }
       return retList;
    }

    public List<String> getToDosForHibernate(String user) {
        List<String> retList = new ArrayList<String>();
        List<String> toDos = toDoService.getTodos(user);
        for (String toDo : toDos) {
            if (toDo.contains("Hibernate")) {
                retList.add(toDo);
            }
        }
        return retList;
    }

    public void deleteToDo(String todo) {
        toDoService.deleteTodo(todo);
//        toDoService.deleteAllTodos();
    }
}
