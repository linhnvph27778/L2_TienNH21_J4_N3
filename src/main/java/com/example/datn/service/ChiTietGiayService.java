package com.example.datn.service;

import com.example.datn.entity.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietGiayService {

    List<ChiTietGiay> getAll();

    void add(ChiTietGiay chiTietGiay);

    void delete(ChiTietGiay chiTietGiay);

    Optional<ChiTietGiay> getOne(UUID id);

    Page<ChiTietGiay> phanTrang(int pageNo, int size);

    List<ChiTietGiay> findByIdGiay(UUID idGiay);

    List<MauSac> findMauSacByIDGiay(UUID idGiay);

    List<MauSac> findDistinctMauSacBySizeAndGiay(UUID idGiay, UUID idSize);

    List<Size> findSizeByIDGiay(UUID idGiay);

    List<ChatLieuDeGiay> findCLDGIDGiay(UUID idGiay);

    List<ChatLieuThanGiay> findCLTGByIDGiay(UUID idGiay);

    List<ChiTietGiay> findByIDGiayAndIDSize(Giay giay, Size size);
}
