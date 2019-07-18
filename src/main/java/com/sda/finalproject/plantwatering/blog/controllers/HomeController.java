package com.sda.finalproject.plantwatering.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping ("/index")
    public String index(){
        return "index";
    }

    @RequestMapping ("/contact")
    public String contact(){
        return "contact";
    }

}
