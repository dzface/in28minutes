package com.example.in28min.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)   // 예제하고 다르게 value를 명시해주어야만 인식
    public String goToMainPage(ModelMap model) {
        model.put("name", getLoggedInUserName());
        return "mainJsp";
    }
    private String getLoggedInUserName(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
