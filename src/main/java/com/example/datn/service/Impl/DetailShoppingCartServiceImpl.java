package com.example.datn.service.Impl;

import com.example.datn.entity.ChiTietGiay;
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
    public List<GioHangChiTiet> findByGioHangActive(GioHang gioHang) {
        return detailShoppingCartRepository.findGHCTOrderByTime(gioHang);
    }

    @Override
    public GioHangChiTiet addProduct(GioHangChiTiet gh) {
        return detailShoppingCartRepository.save(gh);
    }

    @Override
    public GioHangChiTiet findByIDCTG(ChiTietGiay ctg) {
        return detailShoppingCartRepository.findByChiTietGiayAndTrangThai(ctg, 1);
    }
}
