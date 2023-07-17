package com.example.datn.service;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietGiayService {

    List<ChiTietGiay> getAll();

    void add(ChiTietGiay chiTietGiay);

    void delete(ChiTietGiay chiTietGiay);

    Optional<ChiTietGiay> getOne(UUID id);

    Page<ChiTietGiay> phanTrang(int pageNo, int size);

    List<ChiTietGiay> findByIdGiay(UUID idGiay);

}
