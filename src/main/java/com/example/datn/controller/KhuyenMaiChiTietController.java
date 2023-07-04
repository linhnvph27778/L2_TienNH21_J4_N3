package com.example.datn.controller;


import com.example.datn.entity.KhuyenMaiChiTiet;
import com.example.datn.repository.ChiTietGiayRepo;

import com.example.datn.repository.DotKhuyenMaiRepo;
import com.example.datn.repository.KhuyenMaiChiTietRepo;

import com.example.datn.viewModel.KhuyenMaiChiTietVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("KhuyenMaiChiTiet")
public class KhuyenMaiChiTietController {
    @Autowired
    private KhuyenMaiChiTietRepo khuyenMaiChiTiet;

    @Autowired
    private DotKhuyenMaiRepo dotKhuyenMaiRepo;

    @Autowired
    private ChiTietGiayRepo chiTietGiayRepo;

    @GetMapping("index")
    private String index(Model model){
        model.addAttribute("data",khuyenMaiChiTiet.findAll());


        return "KhuyenMaiChiTiet/index1";
    }

    @PostMapping("store")
    private String store(Model model,@ModelAttribute("d") KhuyenMaiChiTietVM vm){
        KhuyenMaiChiTiet n = new KhuyenMaiChiTiet();

        n.loadFromVM(vm);
        this.khuyenMaiChiTiet.save(n);

        return "redirect:/KhuyenMaiChiTiet/index";
    }

    @GetMapping("create")
    private String create(Model model){
        KhuyenMaiChiTietVM v = new KhuyenMaiChiTietVM();
        model.addAttribute("d",v);
        model.addAttribute("dskm",dotKhuyenMaiRepo.findAll());
        model.addAttribute("dsgiay",chiTietGiayRepo.findAll());
        model.addAttribute("action","/KhuyenMaiChiTiet/store");

        return "KhuyenMaiChiTiet/create";
    }

    @GetMapping("edit/{id}")
    private String detail(Model model,@PathVariable("id")KhuyenMaiChiTiet e){
        model.addAttribute("action","/KhuyenMaiChiTiet/update/" + e.getId());
        KhuyenMaiChiTietVM m = new KhuyenMaiChiTietVM();
        model.addAttribute("d",m);
        model.addAttribute("dskm",dotKhuyenMaiRepo.findAll());
        model.addAttribute("dsgiay",chiTietGiayRepo.findAll());
        m.loadFromEn(e);


        return "KhuyenMaiChiTiet/create";
    }

    @PostMapping("update/{id}")
    private String update(Model model,@PathVariable("id") KhuyenMaiChiTiet e,@ModelAttribute("d")KhuyenMaiChiTietVM vm){
        e.loadFromVM(vm);
        this.khuyenMaiChiTiet.save(e);

        return "redirect:/KhuyenMaiChiTiet/index";
    }
    @GetMapping("delete/{id}")
    private String delete(Model model,@PathVariable("id") KhuyenMaiChiTiet e){
        khuyenMaiChiTiet.delete(e);

        return "redirect:/KhuyenMaiChiTiet/index";
    }
}
