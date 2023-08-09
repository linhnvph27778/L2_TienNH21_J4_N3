package com.example.datn.service;

import com.example.datn.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    void add(KhachHang khachHang);

    void delete(KhachHang khachHang);

    Optional<KhachHang> getOne(UUID id);

    Page<KhachHang> phanTrang(int pageNo, int size);

    KhachHang checkMa(String ma);

    KhachHang checkLogin(String email, String pass);

    KhachHang checkEmail(String email);

    void addNewKhachHang(KhachHang kh);

    //Page<KhachHang> search(String keyword, String loaiKH, int pageNo,int size);
    List<KhachHang> findKhachHangByHoTenOrSDT(String keyword);
}
