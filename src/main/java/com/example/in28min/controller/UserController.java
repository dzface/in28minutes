package com.example.in28min.controller;

import com.example.in28min.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)   // 예제하고 다르게 value를 명시해주어야만 인식
    public String goToMainPage(ModelMap model) {
        model.put("name", "in28minutes");
        return "mainJsp";
    }
}
