package com.example.datn.controller;

import com.example.datn.entity.Hang;
import com.example.datn.entity.HinhAnh;
import com.example.datn.repository.HinhAnhRepo;
import com.example.datn.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class HinhAnhController {
    @Autowired
    HinhAnhService service;
    @Autowired
    HinhAnhRepo repo;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @RequestMapping("/viewsManage/hinhanh/index")
    public String index(Model model) {
        List<HinhAnh> items = repo.findAll();
        model.addAttribute("items", items);
        model.addAttribute("hinhanh", new HinhAnh());
        return "/viewsManage/hinhanh/hinhanh-index";
    }
    @PostMapping("/viewsManage/hinhanh/add")
    public String add(@ModelAttribute("hinhanh") HinhAnh hinhanh) {
        service.save(hinhanh);
        return "redirect:/viewsManage/hinhanh/index";
    }

    @GetMapping("/viewsManage/hinhanh/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        HinhAnh hinhanh = service.getByIdHinhAnh(id);
        model.addAttribute("hinhAnhDetail", hinhanh);
        return "viewsManage/hinhanh/hinhanh-detail";
    }

    @GetMapping("/viewsManage/hinhanh/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        HinhAnh hinhanh = service.getByIdHinhAnh(id);
        model.addAttribute("hinhanh", hinhanh);
        return "viewsManage/hinhanh/hinhanh-update";
    }

    @PostMapping("/viewsManage/hinhanh/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("hinhanh") HinhAnh hinhanh) {
        HinhAnh hinhAnhDb = service.getByIdHinhAnh(id);
        if (hinhAnhDb != null) {
            hinhAnhDb.setTrangThai(hinhanh.getTrangThai());
            hinhAnhDb.setUrlImg0(hinhanh.getUrlImg0());
            hinhAnhDb.setUrlImg1(hinhanh.getUrlImg1());
            hinhAnhDb.setUrlImg2(hinhanh.getUrlImg2());
            hinhAnhDb.setUrlImg3(hinhanh.getUrlImg3());
            hinhAnhDb.setTrangThai(hinhanh.getTrangThai());
            service.save(hinhAnhDb);
        }
        return "redirect:/viewsManage/hinhanh/index";
    }

    @RequestMapping("/viewsManage/hinhanh/remove/{id}")
    public String delete(@PathVariable UUID id) {
        service.deleteByIdHinhAnh(id);
        return "redirect:/viewsManage/hinhanh/index";
    }
}
