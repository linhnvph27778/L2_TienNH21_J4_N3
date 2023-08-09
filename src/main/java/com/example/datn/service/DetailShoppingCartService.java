package com.example.datn.service;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailShoppingCartService {

    List<GioHangChiTiet> findByGioHangActive(GioHang gioHang);

    GioHangChiTiet addProduct(GioHangChiTiet gh);

    GioHangChiTiet findByIDCTG(ChiTietGiay ctg);

}
