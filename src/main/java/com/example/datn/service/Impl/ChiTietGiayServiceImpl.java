package com.example.datn.service.Impl;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.repository.ChiTietGiayRepo;
import com.example.datn.service.ChiTietGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietGiayServiceImpl implements ChiTietGiayService {
    @Autowired
    private ChiTietGiayRepo chiTietGiayRepo ;

    @Override
    public List<ChiTietGiay> getAll() {
        return chiTietGiayRepo.findAll();
    }

    @Override
    public void add(ChiTietGiay chiTietGiay) {
        chiTietGiayRepo.save(chiTietGiay);
    }

    @Override
    public void delete(ChiTietGiay chiTietGiay) {
        chiTietGiayRepo.delete(chiTietGiay);
    }

    @Override
    public Optional<ChiTietGiay> getOne(UUID id) {
        return chiTietGiayRepo.findById(id);
    }

    @Override
    public Page<ChiTietGiay> phanTrang(int pageNo, int size) {
        return null;
    }

    @Override
    public List<ChiTietGiay> findByIdGiay(UUID idGiay) {
        return chiTietGiayRepo.findByGiayId(idGiay);
    }

}
