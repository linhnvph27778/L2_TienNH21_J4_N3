package com.example.datn.usersController;

import com.example.datn.entity.*;
import com.example.datn.repository.GiayDistinctRepository;
import com.example.datn.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("viewsUsers")

public class UserProducts {

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
    private GiayDistinctRepository giayDistinctRepository;

    @Autowired
    private GiayDistinctService giayDistinctService;

    @GetMapping("/usersShop")
    private String getUsersProductForm(Model model,
                                       @RequestParam(name = "pageSize", defaultValue = "6") Integer pageSize,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum){

        listBrand = hangService.findBrandActive();
        model.addAttribute("listBrand", listBrand);

        listSizes = sizeService.findSizeActive();
        model.addAttribute("listSize", listSizes);

        listColors=colorService.findMauSacActive();
        model.addAttribute("listColor", listColors);

//        listGiayDistince = giayDistinctService.getAllGiayDistince();
//        model.addAttribute("listProducts", listGiayDistince);

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<GiayDistinct> page = giayDistinctRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listProducts", page.getContent());

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
