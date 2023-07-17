package com.example.datn.service.Impl;

import com.example.datn.entity.MauSac;
import com.example.datn.repository.MauSacRepo;
import com.example.datn.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private MauSacRepo mauSacRepo;

    @Override
    public List<MauSac> findMauSacActive() {
        return mauSacRepo.findByTrangThai(1);
    }
}
