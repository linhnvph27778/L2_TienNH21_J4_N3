package com.example.datn.controller;

import com.example.datn.entity.Cart;
import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.Item;
import com.example.datn.repository.HangRepo;
import com.example.datn.repository.HinhAnhRepo;
import com.example.datn.repository.MauSacRepo;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.KhachHangService;
import com.example.datn.service.SizeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/mua-hang")
public class CartController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private HttpSession session;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("list",chiTietGiayService.getAll());
        return "viewsBanHang/sanpham";
    }

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("idChiTietGiay") UUID idChiTietGiay, Model model) {
        // lấy ctsp từ repo
        Optional<ChiTietGiay> chiTietGiay = chiTietGiayService.getOne(idChiTietGiay);
        //
        double tongTien = 0 ;

        // tạo ra giỏ hàng chi tiết
        Item item = new Item(
                chiTietGiay.get().getId(),
                chiTietGiay.get().getGiay().getTen(),
                chiTietGiay.get().getHinhAnh().getUrlImg0(),
                chiTietGiay.get().getMauSac().getTen(),
                chiTietGiay.get().getSize().getSoSize(),
                chiTietGiay.get().getHang().getTen(),
                1,
                chiTietGiay.get().getGiaBan());
        //lấy gior hàng từ session
        Cart cartSesion = (Cart) httpSession.getAttribute("cart");
        // nếu chưa có giỏ hàng
        if (cartSesion == null) {
            Cart cart = new Cart();
            ArrayList<Item> list = new ArrayList<>();
            list.add(item);
            cart.setItemList(list);
            httpSession.setAttribute("cart", cart);
        } else {
            // nếu có giỏ hàng
            Cart cart = (Cart) httpSession.getAttribute("cart");
            ArrayList<Item> listItem = cart.getItemList();
            // kieemr tra sản phẩm đã có trong giỏ hàng chưa
            // nếu có thì tăng số lwonjg lên 1
            for (Item itemTmp : listItem) {
                if (itemTmp.getIdChiTietGiay().equals(idChiTietGiay)) {
                    itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                    tongTien = Double.valueOf(item.getSoLuong()) * item.getGiaBan().doubleValue() ;
                    model.addAttribute("tongTien",tongTien);
                    return "redirect:/mua-hang/cart/view";
                }
            }
            // không có thì thêm sản phẩm vào
            listItem.add(item);
        }
        tongTien = Double.valueOf(item.getSoLuong()) * item.getGiaBan().doubleValue() ;
        model.addAttribute("tongTien",tongTien);
        System.out.println(tongTien);
        return "redirect:/mua-hang/cart/view";

    }
    @GetMapping("/cart/view")
    public String addToCart(Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        ArrayList<Item> list = cart.getItemList();
        if (cart == null ){
            session.setAttribute("error","Bạn chưa có sp trong giỏ");
        }else {
            model.addAttribute("gioHangChiTiet", list);
            session.setAttribute("message","Thêm vào giỏ hàng thành công");
        }

        //chọn khách hàng
        model.addAttribute("listkh",khachHangService.getAll());
        return "viewsBanHang/banhang";
    }


}
