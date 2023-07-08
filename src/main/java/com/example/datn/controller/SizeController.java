package com.example.datn.controller;

import com.example.datn.entity.ChatLieuThanGiay;
import com.example.datn.entity.Size;
import com.example.datn.repository.CLThanGiayRep;
import com.example.datn.repository.QLSizeRepo;
import com.example.datn.service.SizeService;
import com.example.datn.service.ThanGiayService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("size")
public class SizeController {
    @Autowired
    private QLSizeRepo qlSizeRepo;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private HttpSession session;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("QLSize", sizeService.getAll());
        return "Size/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        Size size = new Size();
        model.addAttribute("CLSize", size);
        model.addAttribute("view", "/size/store");
        return "Size/update";
    }

    @PostMapping("store")
    public String store(Model model, @Valid @ModelAttribute("CLSize") Size size, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/size/store");
            return "Size/update";
        }
        sizeService.add(size);
        return "redirect:/size/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Size size) {
        sizeService.delete(size);
        return "redirect:/size/index";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Size size) {
        model.addAttribute("CLSize", size);
        model.addAttribute("view", "/size/update/" + size.getId());
        return "Size/update";
    }

    @PostMapping("update/{id}")
    public String update(Model model, @Valid @ModelAttribute("CLSize") Size size, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/size/update/" + size.getId());
            return "Size/update";
        }
        sizeService.add(size);
        return "redirect:/size/index";
    }
}
