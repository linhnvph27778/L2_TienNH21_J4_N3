package com.example.datn.controller;

import com.example.datn.entity.DiaChi;
import com.example.datn.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dia-chi")
public class DiaChiController {
    @Autowired
    private DiaChiService diaChiService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<DiaChi> list = diaChiService.getAll();
        model.addAttribute("listDiaChi", list);
        return "/dia-chi/hien-thi";
    }

    @PostMapping("/add")
    public String save(DiaChi diaChi){
        diaChiService.add(diaChi);
        return "redirect:/dia-chi/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id")UUID id, Model model){
        Optional<DiaChi> optional = diaChiService.findById(id);
        model.addAttribute("diaChi", optional.orElse(null));
        hienThi(model);
        return "/dia-chi/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID id){
        diaChiService.delete(id);
        return "redirect:/dia-chi/hien-thi";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id") UUID id, Model model){
        Optional<DiaChi> optional = diaChiService.findById(id);
        model.addAttribute("diaChi", optional.orElse(null));
        return "/dia-chi/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") UUID id, DiaChi dc){
        Optional<DiaChi> optional = diaChiService.findById(id);
        if(optional.isPresent()){
            DiaChi diaChi = optional.get();
            diaChi.setXa(dc.getXa());
            diaChi.setHuyen(dc.getHuyen());
            diaChi.setThanhPho(dc.getThanhPho());
            diaChi.setQuocGia(dc.getQuocGia());
            diaChi.setGhiChu(dc.getGhiChu());
            diaChi.setTenNguoiNhan(dc.getTenNguoiNhan());
            diaChi.setSdtNhan(dc.getSdtNhan());

            diaChiService.add(diaChi);
        }
        return "redirect:/dia-chi/hien-thi";
    }
}
