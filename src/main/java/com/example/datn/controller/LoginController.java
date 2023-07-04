package com.example.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/authencation")
public class LoginController {

    @GetMapping("/s")
    public String getLoginForm(Model model){
//        model.addAttribute("user", new KhachHang());
        return "/s";
    }

}
