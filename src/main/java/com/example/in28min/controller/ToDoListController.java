//package com.example.in28min.controller;
//
//import com.example.in28min.entity.TodoEntity;
//import com.example.in28min.service.TodoService;
//import jakarta.validation.Valid;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Controller
//@SessionAttributes("name")
//public class ToDoListController {
//    private TodoService todoService;
//    private String getLoggedInUserName(ModelMap model){
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
//
//    public ToDoListController(TodoService todoService) {
//        this.todoService = todoService;
//    }
//    @RequestMapping(value = "todo-list", method = RequestMethod.GET)
//    public String showToDolist(ModelMap model){
//        List<TodoEntity> list= todoService.findByUserName("in28minutes");
//        model.addAttribute("list", list);
//        return "toDoListJsp";
//    }
//    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
//    public String showAddToDoItem(ModelMap model){
//        String userName = getLoggedInUserName(model);
//        TodoEntity todoEntity = new TodoEntity(0, userName, "", LocalDate.now().plusMonths(1), false);
//        model.put("todoEntity", todoEntity);
//        return "addToDoJsp";
//    }
//    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
//    public String addToDoItem(ModelMap model, @Valid TodoEntity todoEntity, BindingResult result){
//        if(result.hasErrors()){
//            return "addToDoJsp";
//        }
//        String userName = getLoggedInUserName(model);
//        todoService.addToDoItem(userName, todoEntity.getDescription(), LocalDate.now().plusMonths(1), false);
//        return "redirect:todo-list";
//    }
//    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
//    public String deleteToDoItem(@RequestParam(value = "id") int id){
//        todoService.deleteToDoItem(id);
//
//        return "redirect:todo-list";
//    }
//    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
//    public String updateToDoItem(@RequestParam(value = "id") int id, ModelMap model){
//        TodoEntity todoEntity = todoService.findById(id);
//        model.addAttribute("todoEntity",todoEntity);
//
//        return "addToDoJsp";
//    }
//    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
//    public String updateToDoItem(ModelMap model, @Valid TodoEntity todoEntity, BindingResult result){
//        if(result.hasErrors()){
//            return "addToDoJsp";
//        }
//        String userName = getLoggedInUserName(model);
//        todoEntity.setUserName(userName);
//        todoService.updateToDoItem(todoEntity);
//        return "redirect:todo-list";
//    }
//
//}
