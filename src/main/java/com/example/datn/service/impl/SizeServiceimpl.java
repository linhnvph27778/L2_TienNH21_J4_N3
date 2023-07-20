package com.example.datn.service.impl;

import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.entity.Size;
import com.example.datn.repository.CLDeGiayRep;
import com.example.datn.repository.QLSizeRepo;
import com.example.datn.service.DeGiayService;
import com.example.datn.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SizeServiceimpl implements SizeService {
    @Autowired
    private QLSizeRepo sizeRepo;

    @Override
    public List<Size> getAll() {

        return sizeRepo.findAll();
    }

    @Override
    public void add(Size size) {
        sizeRepo.save(size);
    }

    @Override
    public void delete(Size size) {
        sizeRepo.delete(size);
    }

    @Override
    public Optional<Size> getOne(UUID id) {
        return sizeRepo.findById(id);

    }

    @Override
    public List<Size> findSizeActive() {
        return sizeRepo.findByTrangThaiOrderBySoSize(1);
    }

    @Override
    public Size findByID(UUID id) {
        return sizeRepo.findById(id).orElse(null);
    }
}
