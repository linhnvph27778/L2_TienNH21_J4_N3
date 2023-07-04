package com.example.datn.repository;

import com.example.datn.entity.KhuyenMaiChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhuyenMaiChiTietRepo extends JpaRepository<KhuyenMaiChiTiet, UUID> {
}
