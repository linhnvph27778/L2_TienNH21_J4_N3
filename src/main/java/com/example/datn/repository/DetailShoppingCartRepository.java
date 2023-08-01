package com.example.datn.repository;

import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DetailShoppingCartRepository extends JpaRepository<GioHangChiTiet, UUID> {
    List<GioHangChiTiet> findByGioHang(GioHang gioHang);
}
