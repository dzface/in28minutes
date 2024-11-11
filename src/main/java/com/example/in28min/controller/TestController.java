package com.example.in28min.controller;


import com.sun.tools.javac.Main;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/main")
    @ResponseBody //자료형을 페이지 표시하려면 해당 어노테이션 필요
    public String welcome(){
        return "Welcome bro";
    }

    @RequestMapping(("/main-html"))
    @ResponseBody
    public StringBuffer mainHTML(){
        StringBuffer sb= new StringBuffer();
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<title> Main page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("This is main page!");
        sb.append("</body>");
        sb.append("</html>");
        return sb;
    }

    //JSP 파일 출력
    // path: src/main/webapp/WEB-INF/mainJsp.jsp
    @RequestMapping("/")
    public String mainJsp(){
        return "mainJsp";
    }
}
