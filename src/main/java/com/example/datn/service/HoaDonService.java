package com.example.datn.service;

import com.example.datn.entity.HoaDon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> getAll();

    List<HoaDon> getHoaDonChuaThanhToan();

    void add(HoaDon hoaDon);

    Optional<HoaDon> getOne(UUID id);
}
