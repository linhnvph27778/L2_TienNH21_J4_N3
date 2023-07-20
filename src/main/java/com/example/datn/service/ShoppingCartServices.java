package com.example.datn.service;


import com.example.datn.entity.GioHang;
import com.example.datn.entity.KhachHang;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartServices {

    GioHang findByUser(KhachHang kh);

    GioHang addShoppingCart(GioHang gh);
}
