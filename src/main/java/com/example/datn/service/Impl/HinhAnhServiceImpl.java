package com.example.datn.service.Impl;

import com.example.datn.entity.HinhAnh;
import com.example.datn.repository.HinhAnhRepo;
import com.example.datn.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {
    @Autowired
    HinhAnhRepo repo;
    @Override
    public HinhAnh getByIdHinhAnh(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteByIdHinhAnh(UUID id) {
    repo.deleteById(id);
    }

    @Override
    public void save(HinhAnh hinhAnh) {
    repo.save(hinhAnh);
    }
}
