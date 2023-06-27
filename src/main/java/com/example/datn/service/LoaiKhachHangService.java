package com.example.datn.service;

import com.example.datn.entity.LoaiKhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoaiKhachHangService {
    List<LoaiKhachHang> getAll();

    void add(LoaiKhachHang loaiKhachHang);

    void delete(LoaiKhachHang loaiKhachHang);

    Optional<LoaiKhachHang> getOne(UUID id);

    Page<LoaiKhachHang> phanTrang(int pageNo,int size);

    LoaiKhachHang checkMa(String ma);
}
