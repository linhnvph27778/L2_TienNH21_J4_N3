package com.example.datn.usersController;


import com.example.datn.entity.*;
import com.example.datn.repository.GiayDistinctRepository;
import com.example.datn.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("viewsUsers")
public class UsersDetailProduct {

    private List<Hang> listBrand = new ArrayList<>();
    private List<Size> listSizes = new ArrayList<>();
    private List<MauSac> listColors = new ArrayList<>();
    private List<ChiTietGiay> listProducts = new ArrayList<>();
    private List<GiayDistinct> listGiayDistince = new ArrayList<>();
    private Date date = new Date();


    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private GiayDistinctService giayDistinctService;

    @Autowired
    private DetailShoppingCartService detailShoppingCartService;

    @Autowired
    private GiayService giayService;

    @Autowired
    private ShoppingCartServices shoppingCartServices;


    @GetMapping("/shop-details/{id}")
    private String getDetailProduct(Model model,
                                    @PathVariable(name ="id") UUID idProduct){


        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        checkUsersLogin(model, khachHang);

        session.removeAttribute("productDetail");

        Giay giay = giayService.findByID(idProduct);

        GiayDistinct product = giayDistinctService.findGiayDistinctByIdGiay(idProduct);

        model.addAttribute("product", product);

        session.setAttribute("productDetail",product);


//        listProducts = chiTietGiayService.listDistinctGiay(product.getGiay().getId());
//        model.addAttribute("listProducts", listProducts);

        listProducts = chiTietGiayService.listCTGiayAndActice(product.getGiay());

        model.addAttribute("listProducts", listProducts);


        List<ChatLieuThanGiay> listCLTG = chiTietGiayService.findCLTGByIDGiay(product.getGiay().getId());
        model.addAttribute("listCLTG", listCLTG);

        List<ChatLieuDeGiay> listCLDG = chiTietGiayService.findCLDGIDGiay(product.getGiay().getId());
        model.addAttribute("listCLDG", listCLDG);

        return  "viewsUsers/shop-details";

    }


    @GetMapping("/shop-details/addToCart")
    public String addToCart(@RequestParam("idDProduct") String idDetailProduct,
                            @RequestParam("quantityProduct") int number,Model model) {

        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        checkUsersLogin(model, khachHang);

        if (khachHang == null){
            return "/viewsUsers/authencation/usersLogin";
        }

        ChiTietGiay chiTietGiay = chiTietGiayService.findChiTietGiayById(UUID.fromString(idDetailProduct));

        KhachHang kh = (KhachHang) session.getAttribute("UserLogged");

        GioHang gh = (GioHang) session.getAttribute("userShoppingCartLogin");

        GioHangChiTiet ghct = detailShoppingCartService.findByIDCTG(chiTietGiay);

        if (ghct == null){
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();

            gioHangChiTiet.setChiTietGiay(chiTietGiay);
            gioHangChiTiet.setGioHang(gh);
            gioHangChiTiet.setTrangThai(1);
            gioHangChiTiet.setSoLuong(number);
            gioHangChiTiet.setThoiGianThem(date);

            detailShoppingCartService.addProduct(gioHangChiTiet);

            GiayDistinct product = (GiayDistinct) session.getAttribute("productDetail");

            model.addAttribute("product", product);

            session.setAttribute("productDetail",product);

            listProducts = chiTietGiayService.listCTGiayAndActice(product.getGiay());

            model.addAttribute("listProducts", listProducts);

            model.addAttribute("sumProductInCart", detailShoppingCartService.findByGioHangActive(gh).size());
            return "viewsUsers/shop-details";
        }

        int quantityOld = ghct.getSoLuong();

        ghct.setSoLuong( quantityOld + number);

        detailShoppingCartService.addProduct(ghct);

        GiayDistinct product = (GiayDistinct) session.getAttribute("productDetail");

        model.addAttribute("product", product);

        session.setAttribute("productDetail",product);

        listProducts = chiTietGiayService.listCTGiayAndActice(product.getGiay());
        model.addAttribute("listProducts", listProducts);

        model.addAttribute("sumProductInCart", detailShoppingCartService.findByGioHangActive(gh).size());

        return "viewsUsers/shop-details";
    }

    private void checkUsersLogin(Model model, KhachHang khachHang){
        model.addAttribute("minMaxPrice", true);
        model.addAttribute("remindProduct", true);
        model.addAttribute("money", "$");
        model.addAttribute("space", "-");

        if (khachHang != null){
            model.addAttribute("fullnameLogin", khachHang.getHoTen());
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
            GioHang gh = shoppingCartServices.findByUser(khachHang);
            model.addAttribute("sumProductInCart", detailShoppingCartService.findByGioHangActive(gh).size());

        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }
    }
}
