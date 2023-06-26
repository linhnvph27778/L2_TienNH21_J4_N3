package com.example.datn.controller;

import com.example.datn.entity.Size;
import com.example.datn.repository.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SizeController {
    @Autowired
    private SizeRepo sizeRepo;
    @GetMapping("index")
    public String add(Model model){
        Size size =  new Size();
        size.setSoSize(41);
        size.setMa("size1");
        sizeRepo.save(size);
        model.addAttribute("list",sizeRepo.findAll());
        System.out.print("asb");
        System.out.print("asb");
        System.out.print("NhanPham");
        System.out.print("NhanPham");
        return "index";
    }
}
