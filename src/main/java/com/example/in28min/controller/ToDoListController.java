package com.example.in28min.controller;

import com.example.in28min.entity.TodoEntity;
import com.example.in28min.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoListController {
    private TodoService todoService;
    public ToDoListController(TodoService todoService) {
        this.todoService = todoService;
    }
    @RequestMapping(value = "todo-list", method = RequestMethod.GET)
    public String showToDolist(ModelMap model){
        List<TodoEntity> list= todoService.findByUserName("in28minutes");
        model.addAttribute("list", list);
        return "toDoListJsp";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddToDoItem(ModelMap model){
        String userName = (String)model.get("name");
        TodoEntity todoEntity = new TodoEntity(0, userName, "", LocalDate.now().plusMonths(1), false);
        model.put("todoEntity", todoEntity);
        return "addToDoJsp";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addToDoItem(ModelMap model, @Valid TodoEntity todoEntity, BindingResult result){
        if(result.hasErrors()){
            return "addToDoJsp";
        }
        String userName = (String)model.get("name");
        todoService.addToDoItem(userName, todoEntity.getDescription(), LocalDate.now().plusMonths(1), false);
        return "redirect:todo-list";
    }
}
