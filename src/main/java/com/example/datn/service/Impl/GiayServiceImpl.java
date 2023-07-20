package com.example.datn.service.Impl;

import com.example.datn.entity.Giay;
import com.example.datn.entity.LoaiKhachHang;
import com.example.datn.repository.GiayRepository;
import com.example.datn.service.GiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiayServiceImpl implements GiayService {

    @Autowired
    private GiayRepository giayRepository;

    @Override
    public List<Giay> getAll() {
        return giayRepository.findAll();
    }

    @Override
    public void add(Giay loaiKhachHang) {
        giayRepository.save(loaiKhachHang);
    }

    @Override
    public void delete(Giay loaiKhachHang) {
        giayRepository.delete(loaiKhachHang);
    }

    @Override
    public Optional<Giay> getOne(UUID id) {
        return giayRepository.findById(id);
    }

    @Override
    public Page<Giay> phanTrang(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return giayRepository.findAll(pageable);
    }

    @Override
    public Giay checkMa(String ma) {
        return null;
    }

    @Override
    public Giay findByID(UUID idGiay) {
        return giayRepository.findById(idGiay).orElse(null);
    }
}
