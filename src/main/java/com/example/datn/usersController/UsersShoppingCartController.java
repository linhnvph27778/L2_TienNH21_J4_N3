package com.example.datn.usersController;


import com.example.datn.entity.KhachHang;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers")
public class UsersShoppingCartController {


    @Autowired
    private HttpSession session;

    @GetMapping("/shopping-cart")
    private String getShoppingCartForm(Model model){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }
        return "viewsUsers/shopping-cart";
    }
}
