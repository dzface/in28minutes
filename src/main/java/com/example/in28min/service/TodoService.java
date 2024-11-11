package com.example.in28min.service;

import com.example.in28min.entity.TodoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {

    private static List<TodoEntity> todoList = new ArrayList<>();
    private static int CountList= 0;
    static {
        todoList.add(new TodoEntity(++CountList,"in28minutes","Learn AWS", LocalDate.now().plusMonths(1), false));
        todoList.add(new TodoEntity(++CountList,"in28minutes","Learn Pandas", LocalDate.now().plusMonths(2), false));
        todoList.add(new TodoEntity(++CountList,"in28minutes","Learn Redis", LocalDate.now().plusMonths(3), false));
    }
    public List<TodoEntity> findByUserName(String userName){
        return todoList;
    }
    public void addToDoItem(String userName, String description, LocalDate targetDate, boolean done){
        TodoEntity item = new TodoEntity(++CountList, userName,description,targetDate,done);
        todoList.add(item);
    }
}
