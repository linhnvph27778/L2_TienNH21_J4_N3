package com.example.datn.service.impl;

import com.example.datn.entity.LoaiKhachHang;
import com.example.datn.repository.LoaiKhachHangRepositpry;
import com.example.datn.service.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {
    @Autowired
    private LoaiKhachHangRepositpry loaiKhachHangRepositpry;

    @Override
    public List<LoaiKhachHang> getAll() {
        return loaiKhachHangRepositpry.findAll();
    }

    @Override
    public void add(LoaiKhachHang loaiKhachHang) {
        loaiKhachHangRepositpry.save(loaiKhachHang);
    }

    @Override
    public void delete(LoaiKhachHang loaiKhachHang) {
        loaiKhachHangRepositpry.delete(loaiKhachHang);
    }

    @Override
    public Optional<LoaiKhachHang> getOne(UUID id) {
        return loaiKhachHangRepositpry.findById(id);
    }

    @Override
    public Page<LoaiKhachHang> phanTrang(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return loaiKhachHangRepositpry.findAll(pageable);
    }

    @Override
    public LoaiKhachHang checkMa(String ma) {
        return loaiKhachHangRepositpry.getByMa(ma);
    }
}
