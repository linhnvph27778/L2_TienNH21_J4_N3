package com.example.datn.controller;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.Giay;
import com.example.datn.entity.LoaiKhachHang;
import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.GiayService;
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

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/giay")
public class GiayController {
    @Autowired
    private GiayService giayService;

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private HttpSession session;

    @GetMapping("/hien-thi")
    private String getAll(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute("list", giayService.phanTrang(page, 7));
        return "viewsManage/giay/index";
    }

    @GetMapping("/viewAdd")
    private String viewAdd(Model model) {
        Giay giay = new Giay();
        model.addAttribute("giay", giay);
        model.addAttribute("action", "/giay/add");
        return "viewsManage/giay/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("giay") Giay giay, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "viewsManage/giay/add";
        } else {
            giayService.add(giay);
            session.setAttribute("message", "Thêm thành công");
            return "redirect:/giay/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Giay loaiKhachHang) {
        giayService.delete(loaiKhachHang);
        session.setAttribute("message", "Xóa thành công");
        return "redirect:/giay/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    private String viewUpdate(@PathVariable("id") Giay giay, Model model) {
        model.addAttribute("giay", giay);
        model.addAttribute("action", "/giay/update/" + giay.getId());
        return "viewsManage/giay/add";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("giay") Giay giay, BindingResult result) {
        if (result.hasErrors()) {
            return "viewsManage/giay/add";
        } else {
            giayService.add(giay);
            session.setAttribute("message", "Cập nhật thành công");
            return "redirect:/giay/hien-thi";
        }

    }

    @GetMapping("/detail/{id}")
    public String Detail(@PathVariable UUID id, Model model) {
        List<ChiTietGiay> listCTGiay = chiTietGiayService.findByIdGiay(id);
        model.addAttribute("listCTGiay", listCTGiay);
        return "viewsManage/chitietgiay/index";
    }
}
