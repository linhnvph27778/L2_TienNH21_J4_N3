package com.example.datn.service.Impl;

import com.example.datn.entity.Hang;
import com.example.datn.repository.HangRepo;
import com.example.datn.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HangServiceImpl implements HangService {
    @Autowired
    HangRepo repo;

    @Override
    public Hang getByIdHang(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteByIdHang(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public void save(Hang hang) {
        repo.save(hang);
    }

    @Override
    public List<Hang> findBrandActive() {
        return repo.findByTrangThai(1);
    }
}
