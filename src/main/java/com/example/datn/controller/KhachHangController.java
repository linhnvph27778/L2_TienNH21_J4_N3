package com.example.datn.controller;

import com.example.datn.entity.KhachHang;
import com.example.datn.service.KhachHangService;
import com.example.datn.service.LoaiKhachHangService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private LoaiKhachHangService loaiKhachHangService;

    @Autowired
    private HttpSession session;

    @GetMapping("/hien-thi")
    public String getAll(Model model, @RequestParam(defaultValue = "0",value = "page")int page) {
//        model.addAttribute("list", khachHangService.getAll());
        model.addAttribute("listLKH", loaiKhachHangService.getAll());
        model.addAttribute("list", khachHangService.phanTrang(page,2));
        return "khachhang/index";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        KhachHangViewModel khachHangViewModel = new KhachHangViewModel();
        model.addAttribute("khachHang", khachHangViewModel);
        model.addAttribute("action", "/khach-hang/add");
        model.addAttribute("listLKH", loaiKhachHangService.getAll());
        return "khachhang/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("khachHang") KhachHangViewModel khachHangViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listLKH", loaiKhachHangService.getAll());
            return "khachhang/add";
        } else {
            KhachHang khachHang = new KhachHang();
//                    loaiKhachHangService.checkMa(loaiKhachHangViewModel.getMa());
//
//            if (loaiKhachHang != null) {
//                model.addAttribute("maTrung", "Mã đã tồn tại");
//                return "loaikhachhang/add";
//            } else {
            khachHang.loadFormViewModel(khachHangViewModel);
            khachHangService.add(khachHang);
            session.setAttribute("message", "Thêm thành công");
            return "redirect:/khach-hang/hien-thi";
//            }
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang) {
        khachHangService.delete(khachHang);
        session.setAttribute("message", "Xóa thành công");
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable("id") KhachHang khachHang, Model model) {
        model.addAttribute("khachHang", khachHang);
        model.addAttribute("action", "/khach-hang/update/" + khachHang.getId());
        model.addAttribute("listLKH", loaiKhachHangService.getAll());
        return "khachhang/add";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listLKH", loaiKhachHangService.getAll());
            return "khachhang/add";
        } else {
            khachHangService.add(khachHang);
            session.setAttribute("message", "Cập nhật thành công");
            return "redirect:/khach-hang/hien-thi";
        }
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(value = "keyword",required = false)String keyword,
//                         @RequestParam(value = "loaiKH",required = false)String loaiKH,
//                         Model model, @RequestParam(defaultValue = "0",value = "page")int page){
//        model.addAttribute("listLKH",loaiKhachHangService.getAll());
//        model.addAttribute("list",khachHangService.search(keyword,loaiKH,page,5));
//        return "khachhang/add";
//    }

}
