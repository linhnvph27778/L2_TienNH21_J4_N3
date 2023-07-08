package com.example.datn.service;

import com.example.datn.entity.ChucVu;
import com.example.datn.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface NhanVienService {
    List<NhanVien> getAll();

    void add(NhanVien nhanVien);

    Optional<NhanVien> findById(UUID id);

    void delete(UUID id);

    List<NhanVien> search(String keyWord, String chucVu);


}
