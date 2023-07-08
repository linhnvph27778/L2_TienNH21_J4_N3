package com.example.datn.controller;


import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.repository.CLDeGiayRep;
import com.example.datn.service.DeGiayService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("de-giay")
public class CLDeGiayController {
    @Autowired
    private CLDeGiayRep clDeGiayRep;
    @Autowired
    private DeGiayService deGiayService;
    @Autowired
    private HttpSession session;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("QLDG", deGiayService.getAll());
        return "DeGiay/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        ChatLieuDeGiay chatLieuDeGiay = new ChatLieuDeGiay();
        model.addAttribute("CLDG", chatLieuDeGiay);
        model.addAttribute("view", "/de-giay/store");
        return "DeGiay/update";
    }

    @PostMapping("store")
    public String store(Model model, @Valid @ModelAttribute("CLDG") ChatLieuDeGiay chatLieuDeGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/de-giay/store");
            return "DeGiay/update";
        }
        deGiayService.add(chatLieuDeGiay);
        return "redirect:/de-giay/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChatLieuDeGiay chatLieuDeGiay) {
        deGiayService.delete(chatLieuDeGiay);
        return "redirect:/de-giay/index";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") ChatLieuDeGiay chatLieuDeGiay) {
        model.addAttribute("CLDG", chatLieuDeGiay);
        model.addAttribute("view", "/de-giay/update/" + chatLieuDeGiay.getId());
        return "DeGiay/update";
    }

    @PostMapping("update/{id}")
    public String update(Model model, @Valid @ModelAttribute("CLDG") ChatLieuDeGiay chatLieuDeGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/de-giay/update/" + chatLieuDeGiay.getId());
            return "DeGiay/update";
        }
        deGiayService.add(chatLieuDeGiay);
        return "redirect:/de-giay/index";
    }



}
