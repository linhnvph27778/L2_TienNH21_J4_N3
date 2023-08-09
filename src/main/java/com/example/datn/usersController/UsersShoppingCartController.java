package com.example.datn.usersController;


import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import com.example.datn.entity.KhachHang;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.DetailShoppingCartService;
import com.example.datn.service.ShoppingCartServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("viewsUsers")
public class UsersShoppingCartController {


    private  List<GioHangChiTiet> listCTGH = new ArrayList<>();

    @Autowired
    private HttpSession session;

    @Autowired
    private ShoppingCartServices shoppingCartServices;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private DetailShoppingCartService  detailShoppingCartService;

    @Autowired
    private HttpServletRequest req;

    @GetMapping("/shopping-cart")
    private String getShoppingCartForm(Model model){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");



        fillData(model, khachHang);

        GioHang gh = shoppingCartServices.findByUser(khachHang);

        listCTGH = detailShoppingCartService.findByGioHangActive(gh);
        model.addAttribute("sumProductInCart", listCTGH.size());

        model.addAttribute("listCTGH", listCTGH);

        return "viewsUsers/shopping-cart";
    }

    @GetMapping("/shop-details/deleteProduct/{id}")
    private String getDetailProduct(Model model,
                                    @PathVariable(name ="id") UUID idProduct){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        fillData(model, khachHang);

        ChiTietGiay ctg = chiTietGiayService.findChiTietGiayById(idProduct);

        GioHangChiTiet ghct = detailShoppingCartService.findByIDCTG(ctg);

        ghct.setTrangThai(0);

        detailShoppingCartService.addProduct(ghct);

        GioHang gh = shoppingCartServices.findByUser(khachHang);

        listCTGH = detailShoppingCartService.findByGioHangActive(gh);

        model.addAttribute("sumProductInCart", listCTGH.size());


        System.out.println(listCTGH.size());

        model.addAttribute("listCTGH", listCTGH);


        return "viewsUsers/shopping-cart";
    }

    private void fillData(Model model, KhachHang khachHang){
        model.addAttribute("fullnameLogin", khachHang.getHoTen());
        model.addAttribute("ifFullnameLogin", true);
        model.addAttribute("messageLoginOrSignin", false);
    }

}
