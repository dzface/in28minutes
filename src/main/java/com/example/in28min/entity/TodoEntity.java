package com.example.in28min.entity;

import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

public class TodoEntity {
    private int id;
    private String userName;
    @Size(min = 5, message = "type over than 5 character")
    private String description;
    private LocalDate targetDate;
    private boolean done;
    //예제랑 다르게

    @ConstructorProperties({"id","userName","description","targetDate","done"})
    //예제랑 다르게 @ConstructorProperties를 추가해야함
    public TodoEntity(int id, String userName, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
