package com.example.in28min.service;

import com.example.in28min.entity.TodoEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Predicate<? super TodoEntity> predicate =
                todoEntity -> todoEntity.getUserName().equalsIgnoreCase(userName);
        return todoList.stream().filter(predicate).toList();
    }
    public void addToDoItem(String userName, String description, LocalDate targetDate, boolean done){
        TodoEntity item = new TodoEntity(++CountList, userName,description,targetDate,done);
        todoList.add(item);
    }
    public void deleteToDoItem(int id){
        Predicate<? super TodoEntity> predicate = todoEntity -> todoEntity.getId() ==id;
        todoList.removeIf(predicate);
    }

    public TodoEntity findById(int id){
        Predicate<? super TodoEntity> predicate = todoEntity -> todoEntity.getId() ==id;
        TodoEntity todoEntity = todoList.stream().filter(predicate).findFirst().get();
        return todoEntity;
    }
    public void updateToDoItem(@Valid TodoEntity todoEntity){
        deleteToDoItem(todoEntity.getId());
        todoList.add(todoEntity);
    }
}
