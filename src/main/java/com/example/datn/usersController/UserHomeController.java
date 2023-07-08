package com.example.datn.usersController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers")
public class UserHomeController {

    @RequestMapping(value = {"", "/", "/usersHome", "/homeUser"})
    private String getUsersHomeForm(){


        return "/viewsUsers/usersHome";
    }


}
