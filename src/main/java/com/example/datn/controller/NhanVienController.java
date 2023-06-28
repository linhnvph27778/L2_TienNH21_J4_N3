package com.example.datn.controller;

import com.example.datn.entity.DiaChi;
import com.example.datn.entity.NhanVien;
import com.example.datn.service.ChucVuService;
import com.example.datn.service.DiaChiService;
import com.example.datn.service.NhanVienService;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<NhanVien> list = nhanVienService.getAll();
        model.addAttribute("listNhanVien", list);
        model.addAttribute("listChucVu", chucVuService.getAll());
        return "/nhan-vien/hien-thi";
    }

    @PostMapping("/add")
    public String save(NhanVien nhanVien){
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") UUID id, Model model){
        Optional<NhanVien> optional = nhanVienService.findById(id);
        model.addAttribute("nhanVien", optional.orElse(null));
        hienThi(model);
        return "/nhan-vien/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID id){
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id") UUID id, Model model){
        Optional<NhanVien> optional = nhanVienService.findById(id);
        model.addAttribute("nhanVien", optional.orElse(null));
        model.addAttribute("listChucVu", chucVuService.getAll());
        return "/nhan-vien/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") UUID id, NhanVien nv){
        Optional<NhanVien> optional = nhanVienService.findById(id);
        if(optional.isPresent()){
            NhanVien nhanVien = optional.get();
            nhanVien.setMa(nv.getMa());
            nhanVien.setHoTen(nv.getHoTen());
            nhanVien.setGioiTinh(nv.isGioiTinh());
            nhanVien.setNgaySinh(nv.getNgaySinh());
            nhanVien.setEmail(nv.getEmail());
            nhanVien.setSdt(nv.getSdt());
            nhanVien.setDiaChi(nv.getDiaChi());
            nhanVien.setTrangThai(nv.getTrangThai());
            nhanVien.setPass(nv.getPass());
            nhanVien.setChucVu(nv.getChucVu());

            nhanVienService.add(nhanVien);
        }
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyWord") String keyWord,
                         @RequestParam("chucVu") String maChucVu,
                         Model model){
        model.addAttribute("listChucVu", chucVuService.getAll());
        List<NhanVien> list = nhanVienService.search(keyWord, maChucVu);
        model.addAttribute("listNhanVien", list);
        return "/nhan-vien/hien-thi";
    }
}
