package com.example.datn.usersController;


import com.example.datn.entity.*;
import com.example.datn.repository.GiayDistinctRepository;
import com.example.datn.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("viewsUsers")
public class UserDetailProduct {

    private List<Hang> listBrand = new ArrayList<>();
    private List<Size> listSizes = new ArrayList<>();
    private List<MauSac> listColors = new ArrayList<>();
    private List<ChiTietGiay> listProducts = new ArrayList<>();
    private List<GiayDistinct> listGiayDistince = new ArrayList<>();

    @Autowired
    private HttpSession session;

    @Autowired
    private HangService hangService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private GiayDistinctService giayDistinctService;

    @GetMapping("/shop-details/{id}")
    private String getDetailProduct(Model model,
                                    @PathVariable(name ="id") UUID idProduct){

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }

        listProducts = chiTietGiayService.findByIdGiay(idProduct);
        model.addAttribute("listProducts", listProducts);

        for (ChiTietGiay x:listProducts
             ) {
            System.out.println(x.getMauSac().getTen());
        }
        return  "viewsUsers/shop-details";

    }
}
