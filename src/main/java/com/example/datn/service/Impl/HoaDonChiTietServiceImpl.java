package com.example.datn.service.Impl;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.HoaDonChiTiet;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public void add(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void delete(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }

    @Override
    public List<ChiTietGiay> listHoaDonCho(UUID idHoaDon) {
        return hoaDonChiTietRepository.listHoaDonCho(idHoaDon);
    }

    @Override
    public HoaDonChiTiet getOne(UUID idHoaDon, UUID idChiTietGiay) {
        return hoaDonChiTietRepository.findHoaDonChiTietByIdHoaDonAndIdChiTietGiay(idHoaDon, idChiTietGiay);
    }
}
