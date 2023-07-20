package com.example.datn.controller;

import com.example.datn.entity.Cart;
import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.GiayDistinct;
import com.example.datn.entity.HoaDon;
import com.example.datn.entity.Item;
import com.example.datn.entity.KhachHang;
import com.example.datn.entity.*;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.GiayDistinctService;
import com.example.datn.service.HoaDonService;
import com.example.datn.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

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
    private GiayDistinctService giayDistinctService;

    @Autowired
    private KhachHangService khachHangService;

//    @Autowired
//    private HoaDonService hoaDonService;

//    @GetMapping("/cart")
//    public String taoHoaDon(Model model){
//        String ma = String.valueOf(Math.floor(((Math.random() * 899999) + 100000)));
//        Date ngayTao= new Date();
//        int tinhTrang = 1;
//        HoaDon hd = new HoaDon();
//        hd.setMa(ma);
//        hd.setNgayTao(ngayTao);
//        hd.setTrangThai(tinhTrang);
//        hoaDonService.add(hd);
//        model.addAttribute("idHoaDon",hd.getId());
//        return "redirect:/mua-hang/cart/view/"+hd.getId();
//    }


    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("idChiTietGiay") UUID idChiTietGiay, Model model) {

        model.addAttribute("modalSize", false);
        // lấy ctsp từ repo
        Optional<ChiTietGiay> chiTietGiay = chiTietGiayService.getOne(idChiTietGiay);
        double tongTien = 0;
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
            boolean found = false;
            for (Item itemTmp : listItem) {
                if (itemTmp.getIdChiTietGiay().equals(idChiTietGiay)) {
                    itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                    found = true;
                    break;
                }
            }
            // nếu ch có trong giỏ thì add vào giỏ
            if (!found) {
                listItem.add(item);
            }
            for (Item gioHang : cart.getItemList()) {
                tongTien += gioHang.getSoLuong() * gioHang.getGiaBan();
            }
        }

        httpSession.setAttribute("tongTien",tongTien);
        return "redirect:/mua-hang/cart/view";

    }

    @GetMapping("/chon-tai-khoan/{id}")
    public String chonTaiKhoan(@PathVariable("id") UUID id,Model model){
        model.addAttribute("modalSize", false);
        Optional<KhachHang> khachHang = khachHangService.getOne(id);
        session.setAttribute("hoTen",khachHang.get().getHoTen());
        session.setAttribute("sdt",khachHang.get().getSdt());
        session.setAttribute("email",khachHang.get().getEmail());
        return "redirect:/mua-hang/cart/view";
    }

    @GetMapping("/cart/view")
    public String hienThi(Model model) {
        model.addAttribute("modalSize", false);
        Cart cart = (Cart) httpSession.getAttribute("cart");

        model.addAttribute("list",chiTietGiayService.getAll());
        //chon sp
        model.addAttribute("listChonSanPham",giayDistinctService.getAllGiayDistince());
//        //chọn size giày
//        UUID idGiay = UUID.fromString("267d399f-39ea-4c71-830b-9a2cd340efed");
//        model.addAttribute("listSize",chiTietGiayService.findByIdGiay(idGiay));

        //chon sp
        model.addAttribute("listChonSanPham",giayDistinctService.getAllGiayDistince());
//        //chọn size giày
        UUID idGiay = UUID.fromString("F5D7A5F0-BE44-4470-BEBD-09CB0AC07EA9");
        model.addAttribute("listSize",chiTietGiayService.findByIdGiay(idGiay));

        if (cart == null){
            session.setAttribute("error","Bạn chưa có sản phẩm trong giỏ hàng");
            session.setAttribute("tongTien",0);
            return "viewsBanHang/banhang";
        }
        ArrayList<Item> list = cart.getItemList();
        if (list.isEmpty()){
            session.setAttribute("error", "Bạn chưa có sản phẩm trong giỏ hàng");
            session.setAttribute("tongTien",0);
            return "viewsBanHang/banhang";
        }
        model.addAttribute("gioHangChiTiet", list);
        //chọn khách hàng
        model.addAttribute("listkh",khachHangService.getAll());

        return "viewsBanHang/banhang";
    }
    @GetMapping("/cart/view/chonSize/{id}")
    public String chonSize(@PathVariable("id") UUID idGiay, Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        model.addAttribute("modalSize", true);
        //chon sp
        model.addAttribute("listChonSanPham",giayDistinctService.getAllGiayDistince());



        List<ChiTietGiay> listSize = chiTietGiayService.findByIdGiay(idGiay);
        model.addAttribute("listSize", listSize);
        model.addAttribute("showModal", true);
        return "viewsBanHang/banhang";
    }

}
