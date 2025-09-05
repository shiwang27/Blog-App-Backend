package com.FirstProject.SimpleWebApp.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login page...";
    }
    


}
