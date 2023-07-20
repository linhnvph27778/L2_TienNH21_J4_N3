package com.example.datn.service.Impl;

import com.example.datn.entity.*;
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

    @Override

    public List<MauSac> findMauSacByIDGiay(UUID idGiay) {
        return  chiTietGiayRepo.findDistinctMauSac(idGiay);
    }

    @Override
    public List<Size> findSizeByIDGiay(UUID idGiay) {
        return chiTietGiayRepo.findDistinctSize(idGiay);
    }

    @Override
    public List<MauSac> findDistinctMauSacBySizeAndGiay(UUID idGiay, UUID idSize) {
        return chiTietGiayRepo.findDistinctMauSacBySizeAndGiay(idGiay, idSize);
    }

    @Override
    public List<ChatLieuDeGiay> findCLDGIDGiay(UUID idGiay) {
        return chiTietGiayRepo.findDistinctCLDG(idGiay);
    }

    @Override
    public List<ChatLieuThanGiay> findCLTGByIDGiay(UUID idGiay) {
        return chiTietGiayRepo.findDistinctCLTG(idGiay);
    }

    @Override
    public List<ChiTietGiay> findByIDGiayAndIDSize(Giay giay, Size size) {
        return chiTietGiayRepo.findByGiayAndSize(giay, size);

    public List<ChiTietGiay> findBySize(UUID idGiay) {
        return chiTietGiayRepo.findBySize(idGiay);

    }

}
