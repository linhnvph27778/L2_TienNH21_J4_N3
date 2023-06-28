package com.example.datn.repository;

import com.example.datn.entity.LoaiKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoaiKhachHangRepositpry extends JpaRepository<LoaiKhachHang, UUID> {

    public LoaiKhachHang getByMa(String ma);
}
