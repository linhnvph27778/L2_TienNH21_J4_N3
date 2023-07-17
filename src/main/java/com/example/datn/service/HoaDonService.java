package com.example.datn.service;

import com.example.datn.entity.HoaDon;

import java.util.List;

public interface HoaDonService {

    List<HoaDon> getAll();

    void add(HoaDon hoaDon);
}
