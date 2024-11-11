package com.example.in28min.controller;

import com.example.in28min.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class UserController {
    private AuthenticationService authenticationService;
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)   // 예제하고 다르게 value를 명시해주어야만 인식
    public String login() {
        return "loginJsp";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    // 예제하고 다르게 value를 명시해주어야만 인식
    public String welcome(@RequestParam(value = "name") String name,
                       @RequestParam(value = "password") String password,
                       ModelMap model) {

        if(authenticationService.authenticate(name,password)) {
            model.put("name", name);
            model.put("password", password);
            return "mainJsp";
        } else {
            String errorMessage = "Not Allowed!";
            model.put("errorMessage",errorMessage);
            return "loginJsp";
        }

    }
}
