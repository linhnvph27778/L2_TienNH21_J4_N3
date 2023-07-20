package com.example.datn.repository;

import com.example.datn.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang , UUID> {
//    @Query( value = "select * from KhachHang where Ma like %:keyword%" +
//            " or hoTen like %:keyword% and idLoaiKhachHang like :loaiKH",nativeQuery = true)
//    Page<KhachHang> search(String keyword, String loaiKH, Pageable pageable);

    KhachHang findByEmailAndPassAndTrangThai(String email, String pass, Integer trangThai);

    KhachHang findByEmail(String email);
}
