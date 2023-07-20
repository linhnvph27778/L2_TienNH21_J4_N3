package com.example.datn.repository;

import com.example.datn.entity.GioHang;
import com.example.datn.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ShoppingCartRepository extends JpaRepository<GioHang, UUID> {

    GioHang findByKhachHang(KhachHang kh);
}
