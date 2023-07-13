package com.example.datn.usersController;

import com.example.datn.entity.*;
import com.example.datn.repository.ChiTietGiayRepo;
import com.example.datn.repository.HangRepo;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.ColorService;
import com.example.datn.service.HangService;
import com.example.datn.service.SizeService;
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

public class UserProducts {

    private List<Hang> listBrand = new ArrayList<>();
    private List<Size> listSizes = new ArrayList<>();
    private List<MauSac> listColors = new ArrayList<>();
    private List<ChiTietGiay> listProducts = new ArrayList<>();
    private List<Giay> listGiay = new ArrayList<>();

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HangService hangService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    @GetMapping("/usersShop")
    private String getUsersProductForm(Model model){

        listBrand = hangService.findBrandActive();
        model.addAttribute("listBrand", listBrand);

        listSizes = sizeService.findSizeActive();
        model.addAttribute("listSize", listSizes);

        listColors=colorService.findMauSacActive();
        model.addAttribute("listColor", listColors);

        listProducts = chiTietGiayService.findproductActive();
        model.addAttribute("listProducts", listProducts);

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }

        return "/viewsUsers/usersShop";
    }
}
