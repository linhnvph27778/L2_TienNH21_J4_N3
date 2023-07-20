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
public class UsersDetailProduct {

    private List<Hang> listBrand = new ArrayList<>();
    private List<Size> listSizes = new ArrayList<>();
    private List<MauSac> listColors = new ArrayList<>();
    private List<ChiTietGiay> listProducts = new ArrayList<>();
    private List<GiayDistinct> listGiayDistince = new ArrayList<>();
    private List<ChatLieuDeGiay> chatLieuDeGiayList = new ArrayList<>();
    private List<ChatLieuThanGiay> chatLieuThanGiayList = new ArrayList<>();

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

    @Autowired
    private GiayService giayService;

    @GetMapping("/shop-details/{id}")
    private String getDetailProduct(Model model,
                                    @PathVariable(name ="id") UUID idProduct){

        checkUsersLogin(model);

        session.removeAttribute("productDetail");

        GiayDistinct product = giayDistinctService.findByID(idProduct);
        model.addAttribute("product", product);

        model.addAttribute("money", "$");

        model.addAttribute("space", "-");

        session.setAttribute("productDetail",product);

        listProducts = chiTietGiayService.findByIdGiay(product.getGiay().getId());
        model.addAttribute("listProducts", listProducts);

        List<MauSac> listColor = chiTietGiayService.findMauSacByIDGiay(product.getGiay().getId());
        model.addAttribute("listColor", listColor);

        List<Size> listSize = chiTietGiayService.findSizeByIDGiay(product.getGiay().getId());
        model.addAttribute("listSize", listSize);

        List<ChatLieuThanGiay> listCLTG = chiTietGiayService.findCLTGByIDGiay(product.getGiay().getId());
        model.addAttribute("listCLTG", listCLTG);

        List<ChatLieuDeGiay> listCLDG = chiTietGiayService.findCLDGIDGiay(product.getGiay().getId());
        model.addAttribute("listCLDG", listCLDG);

        return  "viewsUsers/shop-details";

    }

    @GetMapping("/shop-details/{idGiay}/{idtk1}")
    private String getProductSize(Model model,
                                  @PathVariable(name="idGiay") UUID idGiay,
                                  @PathVariable(name="idtk1") UUID idTK1){

        checkUsersLogin(model);

        GiayDistinct giayDistinct = (GiayDistinct) session.getAttribute("productDetail");

        model.addAttribute("product", giayDistinct);


        Size size = sizeService.findByID(idTK1);

        Giay giay = giayService.findByID(idGiay);

        listProducts = chiTietGiayService.findByIDGiayAndIDSize(giay, size);

        if (size != null && listProducts.size()==1){
            listSizes.add(size);
            model.addAttribute("listSize", listSizes);

            for (ChiTietGiay c: listProducts) {
                chatLieuDeGiayList.add(c.getChatLieuDeGiay());
                chatLieuThanGiayList.add(c.getChatLieuThanGiay());
                model.addAttribute("price_product",c.getGiaBan());
            }


            model.addAttribute("listCLDG", chatLieuDeGiayList);
            model.addAttribute("listCLTG", chatLieuThanGiayList);
            List<MauSac> listColor = chiTietGiayService.findDistinctMauSacBySizeAndGiay(idGiay, idTK1);
            model.addAttribute("listColor", listColor);

            return "viewsUsers/shop-details";
        }

        return "viewsUsers/shop-details";
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
}
