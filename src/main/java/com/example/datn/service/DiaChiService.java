package com.example.datn.service;

import com.example.datn.entity.DiaChi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface DiaChiService {
    List<DiaChi> getAll();

    void add(DiaChi diaChi);

    Optional<DiaChi> findById(UUID id);

    void delete(UUID id);


}
