package com.example.datn.service;

import com.example.datn.entity.Hang;

import java.util.List;
import java.util.UUID;

public interface HangService {
    public Hang getByIdHang(UUID id);

    public void deleteByIdHang(UUID id);

    public void save(Hang hang);

    List<Hang> findBrandActive();
}
