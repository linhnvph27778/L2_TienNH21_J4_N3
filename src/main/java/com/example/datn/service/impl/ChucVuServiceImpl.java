package com.example.datn.service.impl;

import com.example.datn.entity.ChucVu;
import com.example.datn.repository.ChucVuRepository;
import com.example.datn.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public void add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public Optional<ChucVu> findById(UUID id) {
        return chucVuRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        chucVuRepository.deleteById(id);
    }
}
