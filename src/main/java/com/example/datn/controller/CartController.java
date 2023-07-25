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
import com.example.datn.service.HoaDonChiTietService;
import com.example.datn.service.HoaDonService;
import com.example.datn.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
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

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/cart")
    public String taoHoaDon(Model model) {
        List<HoaDon> listHD = hoaDonService.getHoaDonChuaThanhToan();
        if (listHD.size() < 3) {
            String ma = String.valueOf(Math.floor(((Math.random() * 899999) + 100000)));
            Date ngayTao = new Date();
            int tinhTrang = 0;
            HoaDon hd = new HoaDon();
            hd.setMa("hd" + ma);
            hd.setNgayTao(ngayTao);
            hd.setTrangThai(tinhTrang);
            hoaDonService.add(hd);
            httpSession.setAttribute("message","Đã tạo hóa đơn");
        } else {
            httpSession.setAttribute("message","Quá số lượng");
        }
        return "redirect:/mua-hang/cart/view";
    }


    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("idChiTietGiay") UUID idChiTietGiay, Model model) {

        model.addAttribute("modalSize", false);
        model.addAttribute("modalFullSP", false);
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

        // thêm vào hóa đơn chi tiết
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setDonGia(BigDecimal.valueOf( item.getGiaBan()));
        hoaDonChiTiet.setSoLuong(item.getSoLuong());
        hoaDonChiTiet.setChiTietGiay(chiTietGiay.get());

        // hoa don
        UUID idHoaDon = (UUID) httpSession.getAttribute("idHoaDon");
        Optional<HoaDon> hoaDon = hoaDonService.getOne(idHoaDon);
        hoaDonChiTiet.setHoaDon(hoaDon.get());

        hoaDonChiTietService.add(hoaDonChiTiet);


        httpSession.setAttribute("tongTien", tongTien);
        return "redirect:/mua-hang/cart/view";

    }

    @GetMapping("/chon-tai-khoan/{id}")
    public String chonTaiKhoan(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("modalSize", false);
        model.addAttribute("modalFullSP", false);
        Optional<KhachHang> khachHang = khachHangService.getOne(id);
        session.setAttribute("hoTen", khachHang.get().getHoTen());
        session.setAttribute("sdt", khachHang.get().getSdt());
        session.setAttribute("email", khachHang.get().getEmail());

        // update kh vào hóa đơn
        UUID idHoaDon = (UUID) httpSession.getAttribute("idHoaDon");
        Optional<HoaDon> hoaDon = hoaDonService.getOne(idHoaDon);
        hoaDon.get().setKhachHang(khachHang.get());
        hoaDonService.add(hoaDon.get());

        return "redirect:/mua-hang/cart/view";
    }

    @GetMapping("/cart/view")
    public String hienThi(Model model) {
        //get hoa đơn chưa thanh toán
        model.addAttribute("listHoaDon", hoaDonService.getHoaDonChuaThanhToan());

        model.addAttribute("modalSize", false);
        model.addAttribute("modalFullSP", false);
        Cart cart = (Cart) httpSession.getAttribute("cart");

        if (cart == null) {
            session.setAttribute("error", "Bạn chưa có sản phẩm trong giỏ hàng");
            session.setAttribute("tongTien", 0);
            return "viewsBanHang/banhang";
        }
        ArrayList<Item> list = cart.getItemList();
        if (list.isEmpty()) {
            session.setAttribute("error", "Bạn chưa có sản phẩm trong giỏ hàng");
            session.setAttribute("tongTien", 0);
            return "viewsBanHang/banhang";
        }
        model.addAttribute("gioHangChiTiet", list);
        //chọn khách hàng
        model.addAttribute("listkh", khachHangService.getAll());

        return "viewsBanHang/banhang";
    }

    @GetMapping("/cart/view/fullSP")
    public String hienThiSP(Model model) {

        model.addAttribute("listChonSanPham", giayDistinctService.getAllGiayDistince());

        model.addAttribute("modalSize", false);
        model.addAttribute("modalFullSP", true);
        return "viewsBanHang/banhang";
    }

    @GetMapping("/cart/view/timKiem")
    public String search(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "giaMin", required = false) double giaMin,
            @RequestParam(value = "giaMax", required = false) double giaMax,
            Model model) {
        model.addAttribute("modalFullSP", true);
        model.addAttribute("modalSize", false);
        model.addAttribute("listChonSanPham", giayDistinctService.timKiem(keyword, giaMin, giaMax));
        return "viewsBanHang/banhang";
    }

    @GetMapping("/cart/view/chonSize/{id}")
    public String chonSize(@PathVariable("id") UUID idGiay, Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        model.addAttribute("modalSize", true);
        model.addAttribute("modalFullSP", false);
        //chon sp
        model.addAttribute("listChonSanPham", giayDistinctService.getAllGiayDistince());

        List<ChiTietGiay> listSize = chiTietGiayService.findByIdGiay(idGiay);
        model.addAttribute("listSize", listSize);

        return "viewsBanHang/banhang";
    }

    @GetMapping("/cart/hoadon/{idHoaDon}")
    public String muaHang(@PathVariable("idHoaDon") UUID idHoaDon,Model model){
        httpSession.setAttribute("idHoaDon",idHoaDon);

        //click vào hóa đơn
        // => hiển thị hóa đơn đang treo
//        List<ChiTietGiay> list = hoaDonChiTietService.listHoaDonCho(idHoaDon);
//        System.out.println("so luong "+list.size());
//        Cart cart = (Cart) httpSession.getAttribute("cart");
//        ArrayList<Item> listItem = cart.getItemList();
//        for (Item listHoaDonCho: list){
//            listItem.add(listHoaDonCho);
//        }

//        model.addAttribute("gioHangChiTiet", listItem);

        model.addAttribute("modalSize", false);
        model.addAttribute("modalFullSP", false);
        return "viewsBanHang/banhang";
    }

    @GetMapping("/cart/thanhtoan")
    public String thanhToan(){
        //câp nhật trạng thái hóa đơn
        UUID idHoaDon = (UUID) httpSession.getAttribute("idHoaDon");
        Optional<HoaDon> hoaDon = hoaDonService.getOne(idHoaDon);
        hoaDon.get().setTrangThai(1);
        hoaDonService.add(hoaDon.get());

        //cập nhật số lượng tồn


        //xóa httpSession
        httpSession.invalidate();

        return "redirect:/mua-hang/cart/view";
    }

    @GetMapping("/cart/treo-hoa-don")
    public String treoHoaDon(){
        httpSession.invalidate();
        return "redirect:/mua-hang/cart/view";
    }

}
