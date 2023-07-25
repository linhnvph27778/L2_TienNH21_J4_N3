package com.example.datn.usersController;


import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import com.example.datn.entity.KhachHang;
import com.example.datn.service.DetailShoppingCartService;
import com.example.datn.service.ShoppingCartServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("viewsUsers")
public class UsersShoppingCartController {


    @Autowired
    private HttpSession session;

    @Autowired
    private ShoppingCartServices shoppingCartServices;

    @Autowired
    private DetailShoppingCartService  detailShoppingCartService;

    @GetMapping("/shopping-cart")
    private String getShoppingCartForm(Model model){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("fullnameLogin", khachHang.getHoTen());
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }

        GioHang gh = shoppingCartServices.findByUser(khachHang);

        List<GioHangChiTiet> listCTGH = new ArrayList<>();

        listCTGH = detailShoppingCartService.findByGioHang(gh);

        model.addAttribute("listCTGH", listCTGH);

        return "viewsUsers/shopping-cart";
    }
}
