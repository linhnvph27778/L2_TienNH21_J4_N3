package com.example.datn.service;

import com.example.datn.entity.MauSac;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorService {
    List<MauSac> findMauSacActive();
}
