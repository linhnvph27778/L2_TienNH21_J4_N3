package com.example.datn.service;


import com.example.datn.entity.Size;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface SizeService {
    List<Size> getAll();

    void add(Size size);

    void delete(Size size);

    Optional<Size> getOne(UUID ma);

    List<Size> findSizeActive();

    Size findByID(UUID id);


    List<Size> sizeGiay(UUID idGiay);
}
