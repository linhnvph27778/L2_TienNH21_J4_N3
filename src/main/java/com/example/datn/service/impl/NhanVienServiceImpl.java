package com.example.datn.service.impl;

import com.example.datn.entity.NhanVien;
import com.example.datn.repository.NhanVienRepository;
import com.example.datn.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public Optional<NhanVien> findById(UUID id) {
        return nhanVienRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public List<NhanVien> search(String keyWord, String chucVu) {
        return nhanVienRepository.search(keyWord, chucVu);
    }
}
