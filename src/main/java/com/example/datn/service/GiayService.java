package com.example.datn.service;

import com.example.datn.entity.Giay;
import com.example.datn.entity.LoaiKhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GiayService {
    List<Giay> getAll();

    void add(Giay loaiKhachHang);

    void delete(Giay loaiKhachHang);

    Optional<Giay> getOne(UUID id);

    Page<Giay> phanTrang(int pageNo, int size);

    Giay checkMa(String ma);
}
