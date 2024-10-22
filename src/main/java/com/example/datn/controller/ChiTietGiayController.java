package com.example.datn.controller;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.Giay;
import com.example.datn.entity.Hang;
import com.example.datn.entity.KhachHang;
import com.example.datn.repository.CLDeGiayRep;
import com.example.datn.repository.CLThanGiayRep;
import com.example.datn.repository.HangRepo;
import com.example.datn.repository.HinhAnhRepo;
import com.example.datn.repository.MauSacRepo;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.GiayService;
import com.example.datn.service.HangService;
import com.example.datn.service.HinhAnhService;
import com.example.datn.service.SizeService;
import com.example.datn.viewModel.KhachHangViewModel;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-giay")
public class ChiTietGiayController {
    @Autowired
    private HttpSession session;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private HinhAnhRepo hinhAnhRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private GiayService giayService;

    @Autowired
    private HangRepo hangRepo;

    @Autowired
    private SizeService sizeService;


    @Autowired
    private CLDeGiayRep clDeGiayRep;

    @Autowired
    private CLThanGiayRep clThanGiayRep;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listCTGiay", chiTietGiayService.getAll());
        return "viewsManage/chitietgiay/index";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        ChiTietGiay chiTietGiay = new ChiTietGiay();
        model.addAttribute("chiTietGiay", chiTietGiay);
        model.addAttribute("hinhAnh", hinhAnhRepo.findAll());
        model.addAttribute("giay", giayService.getAll());
        model.addAttribute("size", sizeService.getAll());
        model.addAttribute("mauSac", mauSacRepo.findAll());
        model.addAttribute("hang", hangRepo.findAll());
        model.addAttribute("chatLieuDeGiay", clDeGiayRep.findAll());
        model.addAttribute("chatLieuThanGiay", clThanGiayRep.findAll());
        model.addAttribute("action", "/chi-tiet-giay/add");
        return "viewsManage/chitietgiay/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("chiTietGiay") ChiTietGiay chiTietGiay, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("hinhAnh", hinhAnhRepo.findAll());
            model.addAttribute("size", sizeService.getAll());
            model.addAttribute("mauSac", mauSacRepo.findAll());
            model.addAttribute("hang", hangRepo.findAll());
            model.addAttribute("chatLieuDeGiay", clDeGiayRep.findAll());
            model.addAttribute("chatLieuThanGiay", clThanGiayRep.findAll());
            model.addAttribute("giay", giayService.getAll());
            return "viewsManage/chitietgiay/add";
        } else {
            chiTietGiayService.add(chiTietGiay);
            session.setAttribute("message", "Thêm thành công");
            return "redirect:/giay/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") ChiTietGiay khachHang) {
        chiTietGiayService.delete(khachHang);
        session.setAttribute("message", "Xóa thành công");
        return "redirect:/chi-tiet-giay/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
//        ChiTietGiay ctGiay = chiTietGiayService.getByIdCtGiay(id);
//        model.addAttribute("ctgiayDetail", ctGiay);
        return "viewsManage/chitietgiay/detail";
    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        ChiTietGiay ctGiay = chiTietGiayService.getByIdCtGiay(id);
        model.addAttribute("chiTietGiay", ctGiay);
        model.addAttribute("hinhAnh", hinhAnhRepo.findAll());
        model.addAttribute("size", sizeService.getAll());
        model.addAttribute("mauSac", mauSacRepo.findAll());
        model.addAttribute("hang", hangRepo.findAll());
        model.addAttribute("chatLieuDeGiay", clDeGiayRep.findAll());
        model.addAttribute("chatLieuThanGiay", clThanGiayRep.findAll());
        model.addAttribute("giay", giayService.getAll());
        return "viewsManage/chitietgiay/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("chiTietGiay") ChiTietGiay chiTietGiay) {
        ChiTietGiay ctGiayDb = chiTietGiayService.getByIdCtGiay(id);
        if (ctGiayDb != null) {
            ctGiayDb.setNamBaoHanh(chiTietGiay.getNamBaoHanh());
            ctGiayDb.setNamSanXuat(chiTietGiay.getNamSanXuat());
            ctGiayDb.setTrongLuong(chiTietGiay.getTrongLuong());
            ctGiayDb.setGiaNhap(chiTietGiay.getGiaNhap());
            ctGiayDb.setGiaBan(chiTietGiay.getGiaBan());
            ctGiayDb.setSoLuongTon(chiTietGiay.getSoLuongTon());
            ctGiayDb.setTrangThai(chiTietGiay.getTrangThai());
            ctGiayDb.setGiay(chiTietGiay.getGiay());
            ctGiayDb.setHinhAnh(chiTietGiay.getHinhAnh());
            ctGiayDb.setChatLieuDeGiay(chiTietGiay.getChatLieuDeGiay());
            ctGiayDb.setChatLieuThanGiay(chiTietGiay.getChatLieuThanGiay());
            ctGiayDb.setHang(chiTietGiay.getHang());
            ctGiayDb.setMauSac(chiTietGiay.getMauSac());
            ctGiayDb.setSize(chiTietGiay.getSize());
            chiTietGiayService.save(ctGiayDb);
        }
        return "redirect:/giay/hien-thi";
    }
}
