package com.lschiltz.apisirh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Schiltz Lucas - Api projet SIRH";
    }

}
