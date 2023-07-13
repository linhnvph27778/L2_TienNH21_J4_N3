package com.example.datn.service;


import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.entity.Size;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SizeService {
    List<Size> getAll();

    void add(Size size);

    void delete(Size size);

    Optional<Size> getOne(UUID ma);

    List<Size> findSizeActive();
}
