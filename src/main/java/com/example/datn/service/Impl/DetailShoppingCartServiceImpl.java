package com.example.datn.service.Impl;

import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import com.example.datn.repository.DetailShoppingCartRepository;
import com.example.datn.service.DetailShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailShoppingCartServiceImpl implements DetailShoppingCartService {

    @Autowired
    private DetailShoppingCartRepository detailShoppingCartRepository;

    @Override
    public List<GioHangChiTiet> findByGioHang(GioHang gioHang) {
        return detailShoppingCartRepository.findByGioHang(gioHang);
    }
}
