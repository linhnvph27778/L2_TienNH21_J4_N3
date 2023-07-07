package com.example.datn.controller;

import com.example.datn.entity.KhachHang;
import com.example.datn.repository.KhachHangRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authencation")
public class LoginController {


    @Autowired
    HttpServletRequest request;

    @Autowired
    KhachHangRepository KHRepo;

    @GetMapping("/login")
    private String getLoginForm(){
        return "/authencation/login";
    }

    @PostMapping("/authencation/login")
    private String checkLogin(Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        KhachHang khachHang = KHRepo.findByMaAndPass(username, password);
        if (khachHang != null){
            return "index";
        }

        System.out.println("Linh an cut");System.out.println("Linh an cut");
        System.out.println("Linh an cut");System.out.println("Linh an cut");System.out.println("Linh an cut");
        System.out.println("Linh an cut");






        return "login";
    }

}
