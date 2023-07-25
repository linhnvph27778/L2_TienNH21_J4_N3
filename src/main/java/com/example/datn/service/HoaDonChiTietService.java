package com.example.datn.service;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll();

    void add(HoaDonChiTiet hoaDonChiTiet);

    //
    List<ChiTietGiay> listHoaDonCho(UUID idHoaDon);
}
