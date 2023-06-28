package com.example.datn.service;

import com.example.datn.entity.ChucVu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ChucVuService {
    List<ChucVu> getAll();

    void add(ChucVu chucVu);

    Optional<ChucVu> findById(UUID id);

    void delete(UUID id);
}
