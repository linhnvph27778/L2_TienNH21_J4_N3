package com.example.datn.service;

import com.example.datn.entity.Hang;
import com.example.datn.entity.HinhAnh;

import java.util.UUID;

public interface HinhAnhService {
    public HinhAnh getByIdHinhAnh(UUID id);

    public void deleteByIdHinhAnh(UUID id);

    public void save(HinhAnh hinhAnh);
}
