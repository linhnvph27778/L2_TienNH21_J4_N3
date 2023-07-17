package com.example.datn.usersController;

import com.example.datn.service.ChiTietGiayService;
import com.example.datn.service.GiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers")
public class UsersProductDetails {

    @Autowired
    private ChiTietGiayService chiTietGiayService;

    @Autowired
    private GiayService giayService;

}
