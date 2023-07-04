package com.example.datn.controller;

import com.example.datn.entity.DotKhuyenMai;
import com.example.datn.entity.MauSac;
import com.example.datn.repository.DotKhuyenMaiRepo;
import com.example.datn.repository.MauSacRepo;
import com.example.datn.viewModel.DotKhuyenMaiVM;
import com.example.datn.viewModel.MauSacVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("MauSac")
public class MauSacController {
    @Autowired
    private MauSacRepo mauSacRepo;

    @GetMapping("index")
    private String index(Model model){
        model.addAttribute("data",mauSacRepo.findAll());

        return "MauSac/index1";
    }

    @PostMapping("store")
    private String store(Model model,@ModelAttribute("d") MauSacVM vm){
        MauSac n = new MauSac();

        n.loadFromVM(vm);
        this.mauSacRepo.save(n);

        return "redirect:/MauSac/index";
    }

    @GetMapping("create")
    private String create(Model model){
        MauSacVM v = new MauSacVM();
        model.addAttribute("d",v);
        model.addAttribute("action","/MauSac/store");

        return "MauSac/create";
    }

    @GetMapping("edit/{id}")
    private String detail(Model model,@PathVariable("id") MauSac e){
        model.addAttribute("action","/MauSac/update/" + e.getId());
        MauSacVM m = new MauSacVM();
        model.addAttribute("d",m);
        m.loadFromEn(e);


        return "MauSac/create";
    }

    @PostMapping("update/{id}")
    private String update(Model model,@PathVariable("id") MauSac e,@ModelAttribute("d") MauSacVM vm){
        e.loadFromVM(vm);
        this.mauSacRepo.save(e);

        return "redirect:/MauSac/index";
    }
    @GetMapping("delete/{id}")
    private String delete(Model model,@PathVariable("id") MauSac e){
        mauSacRepo.delete(e);

        return "redirect:/MauSac/index";
    }
}
