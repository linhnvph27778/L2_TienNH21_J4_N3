package com.example.datn.service.impl;

import com.example.datn.entity.DiaChi;
import com.example.datn.repository.DiaChiRepository;
import com.example.datn.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiaChiServiceImpl implements DiaChiService {
    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public List<DiaChi> getAll() {
        return diaChiRepository.findAll();
    }

    @Override
    public void add(DiaChi diaChi) {
        diaChiRepository.save(diaChi);
    }

    @Override
    public Optional<DiaChi> findById(UUID id) {
        return diaChiRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        diaChiRepository.deleteById(id);
    }


}
