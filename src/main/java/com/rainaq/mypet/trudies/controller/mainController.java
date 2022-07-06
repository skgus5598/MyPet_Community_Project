package com.rainaq.mypet.trudies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @GetMapping("main/main")
    public String mainPage(){
        System.out.println("here");
        return "main/main.html";
    }
}
