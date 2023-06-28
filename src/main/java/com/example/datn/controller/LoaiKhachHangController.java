package com.example.datn.controller;

import com.example.datn.entity.LoaiKhachHang;
import com.example.datn.service.LoaiKhachHangService;
import com.example.datn.viewModel.LoaiKhachHangViewModel;
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

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/loai-khach-hang")
public class LoaiKhachHangController {

    @Autowired
    private LoaiKhachHangService loaiKhachHangService;

    @Autowired
    private HttpSession session;

    @GetMapping("/hien-thi")
    private String getAll(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
//        model.addAttribute("list",loaiKhachHangService.getAll());
        model.addAttribute("list", loaiKhachHangService.phanTrang(page, 2));
        return "loaikhachhang/index";
    }

    @GetMapping("/viewAdd")
    private String viewAdd(Model model) {
        LoaiKhachHangViewModel loaiKhachHang = new LoaiKhachHangViewModel();
        model.addAttribute("loaiKhachHang", loaiKhachHang);
        model.addAttribute("action", "/loai-khach-hang/add");
        return "loaikhachhang/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("loaiKhachHang")LoaiKhachHangViewModel loaiKhachHangViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "loaikhachhang/add";
        } else {
            LoaiKhachHang loaiKhachHang =new LoaiKhachHang();
//                    loaiKhachHangService.checkMa(loaiKhachHangViewModel.getMa());
//
//            if (loaiKhachHang != null) {
//                model.addAttribute("maTrung", "Mã đã tồn tại");
//                return "loaikhachhang/add";
//            } else {
                loaiKhachHang.loadFromVM(loaiKhachHangViewModel);
                System.out.println(loaiKhachHangViewModel.getTen());
                loaiKhachHangService.add(loaiKhachHang);
                session.setAttribute("message","Thêm thành công");
                return "redirect:/loai-khach-hang/hien-thi";
//            }
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") LoaiKhachHang loaiKhachHang) {
        loaiKhachHangService.delete(loaiKhachHang);
        session.setAttribute("message","Xóa thành công");
        return "redirect:/loai-khach-hang/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    private String viewUpdate(@PathVariable("id") LoaiKhachHang loaiKhachHang, Model model) {
        model.addAttribute("loaiKhachHang", loaiKhachHang);
        model.addAttribute("action", "/loai-khach-hang/update/" + loaiKhachHang.getId());
        return "loaikhachhang/add";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("loaiKhachHang") LoaiKhachHang loaiKhachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "loaikhachhang/add";
        } else {
            loaiKhachHangService.add(loaiKhachHang);
            session.setAttribute("message","Cập nhật thành công");
            return "redirect:/loai-khach-hang/hien-thi";
        }

    }
}
