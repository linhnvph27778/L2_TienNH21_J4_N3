package com.example.datn.service;

import com.example.datn.entity.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll();

    void add(HoaDonChiTiet hoaDonChiTiet);
}
