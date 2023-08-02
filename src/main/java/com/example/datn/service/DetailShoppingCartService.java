package com.example.datn.service;

import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailShoppingCartService {

    List<GioHangChiTiet> findByGioHang(GioHang gioHang);

}
