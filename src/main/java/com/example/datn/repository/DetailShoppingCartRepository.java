package com.example.datn.repository;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.GioHang;
import com.example.datn.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DetailShoppingCartRepository extends JpaRepository<GioHangChiTiet, UUID> {

    @Query("SELECT g FROM GioHangChiTiet g WHERE g.gioHang = ?1 AND g.trangThai = 1 ORDER BY g.thoiGianThem")
    List<GioHangChiTiet> findGHCTOrderByTime(GioHang gioHang);

    GioHangChiTiet findByChiTietGiayAndTrangThai(ChiTietGiay ctg, int trangThai);
}
