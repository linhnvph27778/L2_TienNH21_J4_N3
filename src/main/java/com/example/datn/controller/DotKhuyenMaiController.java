package com.example.datn.controller;

import com.example.datn.entity.DotKhuyenMai;
import com.example.datn.repository.DotKhuyenMaiRepo;
import com.example.datn.viewModel.DotKhuyenMaiVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("DotKhuyenMai")
public class DotKhuyenMaiController {
    @Autowired
    private DotKhuyenMaiRepo dotKhuyenMaiRepo;

    @GetMapping("index")
    private String index(Model model){
        model.addAttribute("data",dotKhuyenMaiRepo.findAll());

        return "DotKhuyenMai/index1";
    }

    @PostMapping("store")
    private String store(Model model,@ModelAttribute("d") DotKhuyenMaiVM vm){
        DotKhuyenMai n = new DotKhuyenMai();

        n.loadFromVM(vm);
        this.dotKhuyenMaiRepo.save(n);

        return "redirect:/DotKhuyenMai/index";
    }

    @GetMapping("create")
    private String create(Model model){
        DotKhuyenMaiVM v = new DotKhuyenMaiVM();
        model.addAttribute("d",v);
        model.addAttribute("action","/DotKhuyenMai/store");

        return "DotKhuyenMai/create";
    }

    @GetMapping("edit/{id}")
    private String detail(Model model,@PathVariable("id") DotKhuyenMai e){
        model.addAttribute("action","/DotKhuyenMai/update/" + e.getId());
        DotKhuyenMaiVM m = new DotKhuyenMaiVM();
        model.addAttribute("d",m);
        m.loadFromEn(e);


        return "DotKhuyenMai/create";
    }

    @PostMapping("update/{id}")
    private String update(Model model,@PathVariable("id") DotKhuyenMai e,@ModelAttribute("d") DotKhuyenMaiVM vm){
        e.loadFromVM(vm);
        this.dotKhuyenMaiRepo.save(e);

        return "redirect:/DotKhuyenMai/index";
    }
    @GetMapping("delete/{id}")
    private String delete(Model model,@PathVariable("id") DotKhuyenMai e){
        dotKhuyenMaiRepo.delete(e);

        return "redirect:/DotKhuyenMai/index";
    }
}
