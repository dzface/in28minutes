package com.example.in28min.repository;

import com.example.in28min.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoEntityRepository extends JpaRepository<TodoEntity,Integer > {
    public List<TodoEntity> findByUserName(String userName);
}
