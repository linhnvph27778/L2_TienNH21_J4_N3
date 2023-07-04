package com.example.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authencation")
public class LoginController {

    @GetMapping("/login")
    private String getLoginForm(){
        return "/authencation/login";
    }

}
