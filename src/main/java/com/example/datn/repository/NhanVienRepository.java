package com.example.datn.repository;

import com.example.datn.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "select * from NhanVien where (ma like %:keyWord% or hoTen like %:keyWord%) "+
            " and (idChucVu like :maChucVu)",nativeQuery = true)
    List<NhanVien> search(String keyWord, String maChucVu);
}
