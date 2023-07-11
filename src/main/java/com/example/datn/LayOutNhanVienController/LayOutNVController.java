package com.example.datn.LayOutNhanVienController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayOutNVController {
    @RequestMapping("viewBanHang")
    public String getlayOut(){
        return "viewsNhanVien/LayOutNhanVien";
    }
}
