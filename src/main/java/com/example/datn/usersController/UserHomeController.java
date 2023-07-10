package com.example.datn.usersController;

import com.example.datn.entity.KhachHang;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers")
public class UserHomeController {

    @RequestMapping(value = {"", "/", "/usersHome", "/homeUser"})
    private String getUsersHomeForm(Model model, HttpSession session){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("messageLoginOrSignin", true);
        }
        return "/viewsUsers/usersHome";
    }


}
