package com.example.datn.controller;

import com.example.datn.entity.Hang;
import com.example.datn.repository.HangRepo;
import com.example.datn.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class HangController {
    @Autowired
    HangService service;
    @Autowired
    HangRepo repo;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @RequestMapping("/hang/index")
    public String index(Model model) {
        List<Hang> items = repo.findAll();
        model.addAttribute("items", items);
        model.addAttribute("hang", new Hang());
        return "/hang/hang-index";
    }

    @PostMapping("/hang/add")
    public String add(@ModelAttribute("hang") Hang hang) {
        service.save(hang);
        return "redirect:/hang/index";
    }

    @GetMapping("/hang/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        Hang hang = service.getByIdHang(id);
        model.addAttribute("hangDetail", hang);
        return "hang/hang-detail";
    }

    @GetMapping("/hang/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        Hang hang = service.getByIdHang(id);
        model.addAttribute("hang", hang);
        return "hang/hang-update";
    }

    @PostMapping("/hang/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("hang") Hang hang) {
        Hang hangDb = service.getByIdHang(id);
        if (hangDb != null) {
            hangDb.setMa(hang.getMa());
            hangDb.setTen(hang.getTen());
            hangDb.setTrangThai(hang.getTrangThai());
            service.save(hangDb);
        }
        return "redirect:/hang/index";
    }

    @RequestMapping("/hang/remove/{id}")
    public String delete(@PathVariable UUID id) {
        service.deleteByIdHang(id);
        return "redirect:/hang/index";
    }
}
