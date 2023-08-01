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
import com.example.datn.service.SizeService;
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

    @Autowired
    private SizeService sizeService;

    @GetMapping("/cart")
    public String taoHoaDon() {
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
            httpSession.setAttribute("message", "Tạo hóa đơn thành công");
        } else if (listHD.size() == -1) {
            httpSession.setAttribute("message", "Hãy tạo hóa đơn");
        } else {
            httpSession.setAttribute("message", "Quá số lượng");
        }
        return "redirect:/mua-hang/cart/view";
    }


    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("idChiTietGiay") UUID idChiTietGiay,
                            @RequestParam("soLuong") int soLuong, Model model) {

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
                soLuong,
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
            // nếu có thì tăng số lwonjg lên
            boolean found = false;
            for (Item itemTmp : listItem) {
                if (itemTmp.getIdChiTietGiay().equals(idChiTietGiay)) {
                    itemTmp.setSoLuong(itemTmp.getSoLuong() + soLuong);
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
        // lấy id hoa don
        UUID idHoaDon = (UUID) httpSession.getAttribute("idHoaDon");


        // thêm vào hóa đơn chi tiết
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.getOne(idHoaDon, idChiTietGiay);

        // nếu chưa có hóa đơn chi tiết thì thêm mới
        if (hoaDonChiTiet == null) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setDonGia(BigDecimal.valueOf(item.getGiaBan()));
            hdct.setSoLuong(item.getSoLuong());
            hdct.setChiTietGiay(chiTietGiay.get());

            Optional<HoaDon> hoaDon = hoaDonService.getOne(idHoaDon);
            hdct.setHoaDon(hoaDon.get());
            hoaDonChiTietService.add(hdct);
        } else {
            // nếu có hóa đơn chi tiết rồi thì cập nhật số lượng
            hoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong() + soLuong);
            hoaDonChiTietService.add(hoaDonChiTiet);
        }

        // cập nhật số lượng tồn trong chi tiết giày
        ChiTietGiay ctg = chiTietGiayService.findChiTietGiayById(idChiTietGiay);
        ctg.setSoLuongTon(chiTietGiay.get().getSoLuongTon()-soLuong);
        chiTietGiayService.add(ctg);

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
        List<GiayDistinct> giayDistinctList = giayDistinctService.getAllGiayDistince();

        for (GiayDistinct g : giayDistinctList) {
            model.addAttribute("listSize_" + g.getGiay().getId(), giayDistinctService.soSize(g.getGiay().getId()));
            System.out.println(sizeService.sizeGiay(g.getGiay().getId()));
        }

        model.addAttribute("listChonSanPham", giayDistinctList);

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
    public String muaHang(@PathVariable("idHoaDon") UUID idHoaDon, Model model) {
        httpSession.setAttribute("idHoaDon", idHoaDon);

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
    public String thanhToan() {
        //câp nhật trạng thái hóa đơn va tong tien
        UUID idHoaDon = (UUID) httpSession.getAttribute("idHoaDon");
        Optional<HoaDon> hoaDon = hoaDonService.getOne(idHoaDon);
        hoaDon.get().setTrangThai(1);

        double tongTien = (double) httpSession.getAttribute("tongTien");
        System.out.println(tongTien);
        hoaDon.get().setTongTien(BigDecimal.valueOf(tongTien));
        hoaDonService.add(hoaDon.get());

        //xóa httpSession
        httpSession.invalidate();

        return "redirect:/mua-hang/cart/view";
    }

    @GetMapping("/cart/treo-hoa-don")
    public String treoHoaDon() {
        httpSession.invalidate();
        return "redirect:/mua-hang/cart/view";
    }

}
