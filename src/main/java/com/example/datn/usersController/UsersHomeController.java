package com.example.datn.usersController;

import com.example.datn.entity.KhachHang;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers")
public class UsersHomeController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"", "/", "/usersHome", "/homeUser"})
    private String getUsersHomeForm(Model model){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("fullnameLogin", khachHang.getHoTen());
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }
        return "/viewsUsers/usersHome";
    }

    @GetMapping("/usersLogout")
    private String usersLogout(){
        session.invalidate();
        return "/viewsUsers/authencation/usersLogin";
    }


}
