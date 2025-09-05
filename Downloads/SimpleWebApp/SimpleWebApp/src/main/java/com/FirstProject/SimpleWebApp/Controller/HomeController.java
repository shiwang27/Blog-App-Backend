package com.FirstProject.SimpleWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

    @RequestMapping("/") 
    public String greet(){
        return "welcome to project";
    }

    @RequestMapping("/about")
    public String about(){
        return "we are creating our very first project";
    }
    
}
