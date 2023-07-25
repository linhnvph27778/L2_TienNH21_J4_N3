package com.example.datn.repository;

import com.example.datn.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon , UUID> {

    @Query(value = "select * from HoaDon where TrangThai = 0 ",nativeQuery = true)
    List<HoaDon> listChuaThanhToan();
}
