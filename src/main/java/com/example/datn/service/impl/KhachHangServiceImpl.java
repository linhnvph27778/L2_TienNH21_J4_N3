package com.example.datn.service.Impl;

import com.example.datn.entity.KhachHang;
import com.example.datn.repository.KhachHangRepository;
import com.example.datn.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(KhachHang khachHang) {
        khachHangRepository.delete(khachHang);
    }

    @Override
    public Optional<KhachHang> getOne(UUID id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public Page<KhachHang> phanTrang(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang checkMa(String ma) {
        return null;
    }

    @Override
    public KhachHang checkLogin(String email, String pass) {
        return khachHangRepository.findByEmailAndPassAndTrangThai(email, pass, 1);
    }

    @Override
    public KhachHang checkEmail(String email) {
        return khachHangRepository.findByEmail(email);
    }

    @Override
    public void addNewKhachHang(KhachHang kh) {
        khachHangRepository.save(kh);
    }


//    @Override
//    public Page<KhachHang> search(String keyword, String loaiKH, int pageNo, int size) {
//        Pageable pageable = PageRequest.of(pageNo, size);
//        return khachHangRepository.search(keyword,loaiKH,pageable);
//    }
}
