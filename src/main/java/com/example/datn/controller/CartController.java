package com.example.datn.controller;

import com.example.datn.entity.Cart;
import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.Item;
import com.example.datn.entity.KhachHang;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        double tongTien=0;
        // tạo ra giỏ hàng chi tiết
        Item item = new Item(
                chiTietGiay.get().getId(),
                chiTietGiay.get().getGiay().getMa(),
                chiTietGiay.get().getGiay().getTen(),
                chiTietGiay.get().getHinhAnh().getUrlImg0(),
                chiTietGiay.get().getMauSac().getTen(),
                chiTietGiay.get().getSize().getSoSize(),
                chiTietGiay.get().getHang().getTen(),
                1,
                chiTietGiay.get().getGiaBan().doubleValue());
        //lấy gior hàng từ session
        Cart cartSesion = (Cart) httpSession.getAttribute("cart");
        // nếu chưa có giỏ hàng
        if (cartSesion == null) {
            Cart cart = new Cart();
            ArrayList<Item> list = new ArrayList<>();
            list.add(item);
            cart.setItemList(list);
            tongTien = item.getSoLuong() * item.getGiaBan();
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
                    tongTien += itemTmp.getSoLuong() *itemTmp.getGiaBan();
                    httpSession.setAttribute("tongTien",tongTien);
                    return "redirect:/mua-hang/cart/view";
                }
                tongTien += itemTmp.getSoLuong() *itemTmp.getGiaBan();
                httpSession.setAttribute("tongTien",tongTien);
            }
            // không có thì thêm sản phẩm vào
            tongTien += item.getSoLuong() * item.getGiaBan();
            listItem.add(item);
        }
        httpSession.setAttribute("tongTien",tongTien);
        return "redirect:/mua-hang/cart/view";

    }

    @GetMapping("/chon-tai-khoan/{id}")
    public String chonTaiKhoan(@PathVariable("id") UUID id,Model model){
        Optional<KhachHang> khachHang = khachHangService.getOne(id);
        session.setAttribute("hoTen",khachHang.get().getHoTen());
        session.setAttribute("sdt",khachHang.get().getSdt());
        session.setAttribute("email",khachHang.get().getEmail());

        return "redirect:/mua-hang/cart/view";
    }
    @GetMapping("/cart/view")
    public String addToCart(Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        model.addAttribute("list",chiTietGiayService.getAll());
        ArrayList<Item> list = cart.getItemList();
        if (cart == null ){
            session.setAttribute("error","Bạn chưa có sp trong giỏ");
            return "viewsBanHang/banhang";
        }else {
            model.addAttribute("gioHangChiTiet", list);
            session.setAttribute("message","Thêm vào giỏ hàng thành công");
        }
        model.addAttribute("listkh",khachHangService.getAll());
        //chọn khách hàng

        return "viewsBanHang/banhang";
    }


}
