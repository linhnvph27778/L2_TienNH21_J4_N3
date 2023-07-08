package com.example.datn.controller;

import com.example.datn.entity.ChucVu;
import com.example.datn.entity.DiaChi;
import com.example.datn.service.ChucVuService;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<ChucVu> list = chucVuService.getAll();
        model.addAttribute("listChucVu", list);
        return "/chuc-vu/hien-thi";
    }

    @PostMapping("/add")
    public String save(ChucVu chucVu){
        chucVuService.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") UUID id, Model model){
        Optional<ChucVu> optional = chucVuService.findById(id);
        model.addAttribute("chucVu", optional.orElse(null));
        hienThi(model);
        return "/chuc-vu/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID id){
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id") UUID id, Model model){
        Optional<ChucVu> optional = chucVuService.findById(id);
        model.addAttribute("chucVu", optional.orElse(null));
        return "/chuc-vu/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") UUID id, ChucVu cv){
        Optional<ChucVu> optional = chucVuService.findById(id);
        if(optional.isPresent()){
            ChucVu chucVu = optional.get();
            chucVu.setMa(cv.getMa());
            chucVu.setTen(cv.getTen());
            chucVu.setTrangThai(cv.getTrangThai());


            chucVuService.add(chucVu);
        }
        return "redirect:/chuc-vu/hien-thi";
    }
}
