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

public class UsersProductsController {

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
                                       @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        checkUsersLogin(model);

        showDataUserShop(model);

        model.addAttribute("ChooseAnOption", "Choose an option");

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<GiayDistinct> page = giayDistinctRepository.findAll(pageable);

        model.addAttribute("sumProduct", giayDistinctRepository.findAll().size());


        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listProducts", page.getContent());

        return "/viewsUsers/usersShop";
    }

    @GetMapping("/usersShop/LowToHigh")
    private String sortPriceLTH(Model model,
                                @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        checkUsersLogin(model);

        model.addAttribute("ChooseAnOption", "Low To High");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        Page<GiayDistinct> page = giayDistinctService.priceProductLTH(pageable);

        model.addAttribute("sumProduct", giayDistinctRepository.findAll().size());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listProducts", page.getContent());

        return"/viewsUsers/usersShop";
    }

    @GetMapping("/usersShop/HighToLow")
    private String sortPriceHTL(Model model,
                                @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        checkUsersLogin(model);

        model.addAttribute("ChooseAnOption", "High To Low");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        Page<GiayDistinct> page = giayDistinctService.priceProductHTL(pageable);

        model.addAttribute("sumProduct", giayDistinctRepository.findAll().size());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listProducts", page.getContent());

        return"/viewsUsers/usersShop";
    }








    private void checkUsersLogin(Model model){
        KhachHang khachHang =(KhachHang)  session.getAttribute("UserLogged");

        if (khachHang != null){
            model.addAttribute("ifFullnameLogin", true);
            model.addAttribute("messageLoginOrSignin", false);
        }else{
            model.addAttribute("ifFullnameLogin", false);
            model.addAttribute("messageLoginOrSignin", true);
        }
    }

    private void showDataUserShop(Model model){
        listBrand = hangService.findBrandActive();
        model.addAttribute("listBrand", listBrand);

        listSizes = sizeService.findSizeActive();
        model.addAttribute("listSize", listSizes);

        listColors = colorService.findMauSacActive();
        model.addAttribute("listColor", listColors);
    }


}
