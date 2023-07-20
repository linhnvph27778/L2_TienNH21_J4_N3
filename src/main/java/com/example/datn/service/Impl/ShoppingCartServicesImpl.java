package com.example.datn.service.Impl;

import com.example.datn.entity.GioHang;
import com.example.datn.entity.KhachHang;
import com.example.datn.repository.ShoppingCartRepository;
import com.example.datn.service.ShoppingCartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServicesImpl implements ShoppingCartServices {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    @Override
    public GioHang findByUser(KhachHang kh) {
        return shoppingCartRepository.findByKhachHang(kh);
    }

    @Override
    public GioHang addShoppingCart(GioHang gh) {
        return shoppingCartRepository.save(gh);
    }
}
