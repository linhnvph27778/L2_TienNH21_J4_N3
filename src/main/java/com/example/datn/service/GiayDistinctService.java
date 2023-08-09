package com.example.datn.service;

import com.example.datn.entity.GiayDistinct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GiayDistinctService {

    List<GiayDistinct> getAllGiayDistince();

    GiayDistinct findByID(UUID idGiayDistinct);

    Page<GiayDistinct> priceProductLTH(Pageable pageable);

    Page<GiayDistinct> priceProductHTL(Pageable pageable);

    List<GiayDistinct> timKiem(String keyword,double giaMin, double giaMax);

    List<GiayDistinct> soSize(UUID idGiay);

    GiayDistinct findGiayDistinctByIdGiay(UUID uuid);

    List<GiayDistinct> findGiayDistinctByMauSac(UUID idMauSac);

    List<GiayDistinct> findGiayDistinctByBrand(UUID idBrand);

    List<GiayDistinct> findGiayDistinctBySize(UUID idSize);
}
