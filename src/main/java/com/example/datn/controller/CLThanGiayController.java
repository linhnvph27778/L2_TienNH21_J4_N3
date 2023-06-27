package com.example.datn.controller;

import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.entity.ChatLieuThanGiay;
import com.example.datn.repository.CLDeGiayRep;
import com.example.datn.repository.CLThanGiayRep;
import com.example.datn.service.DeGiayService;
import com.example.datn.service.ThanGiayService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("than-giay")
public class CLThanGiayController {
    @Autowired
    private CLThanGiayRep clThanGiayRep;
    @Autowired
    private ThanGiayService thanGiayService;
    @Autowired
    private HttpSession session;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("QLTG", thanGiayService.getAll());
        return "ThanGiay/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        ChatLieuThanGiay chatLieuThanGiay = new ChatLieuThanGiay();
        model.addAttribute("CLTG", chatLieuThanGiay);
        model.addAttribute("view", "/than-giay/store");
        return "ThanGiay/update";
    }

    @PostMapping("store")
    public String store(Model model, @Valid @ModelAttribute("CLTG") ChatLieuThanGiay chatLieuThanGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/than-giay/store");
            return "ThanGiay/update";
        }
        thanGiayService.add(chatLieuThanGiay);
        return "redirect:/than-giay/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChatLieuThanGiay chatLieuThanGiay) {
        thanGiayService.delete(chatLieuThanGiay);
        return "redirect:/than-giay/index";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") ChatLieuThanGiay chatLieuThanGiay) {
        model.addAttribute("CLTG", chatLieuThanGiay);
        model.addAttribute("view", "/than-giay/update/" + chatLieuThanGiay.getId());
        return "ThanGiay/update";
    }

    @PostMapping("update/{id}")
    public String update(Model model, @Valid @ModelAttribute("CLTG") ChatLieuThanGiay chatLieuThanGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/than-giay/update/" + chatLieuThanGiay.getId());
            return "ThanGiay/update";
        }
        thanGiayService.add(chatLieuThanGiay);
        return "redirect:/than-giay/index";
    }

}
