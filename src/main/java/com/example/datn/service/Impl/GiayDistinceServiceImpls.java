package com.example.datn.service.Impl;

import com.example.datn.entity.GiayDistinct;
import com.example.datn.repository.GiayDistinctRepository;
import com.example.datn.service.GiayDistinctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GiayDistinceServiceImpls implements GiayDistinctService {

    @Autowired
    private GiayDistinctRepository giayDistinctRepository;

    @Override
    public List<GiayDistinct> getAllGiayDistince() {
        return giayDistinctRepository.findAll();
    }

    @Override
    public GiayDistinct findByID(UUID idGiayDistinct) {
        return giayDistinctRepository.findById(idGiayDistinct).orElse(null);
    }

    @Override
    public Page<GiayDistinct> priceProductLTH(Pageable pageable) {
        return giayDistinctRepository.findAllByOrderByMinPriceAsc(pageable);
    }

    @Override
    public Page<GiayDistinct> priceProductHTL(Pageable pageable) {

        return giayDistinctRepository.findAllByOrderByMinPriceDesc(pageable);
    }

    @Override
    public List<GiayDistinct> timKiem(String keyword,double giaMin, double giaMax) {
        return giayDistinctRepository.timKiem(keyword,giaMin,giaMax);
    }

    @Override
    public List<GiayDistinct> soSize(UUID idGiay) {
        return giayDistinctRepository.soSize(idGiay);
    }

    @Override
    public GiayDistinct findGiayDistinctByIdGiay(UUID uuid) {
        return giayDistinctRepository.findGiayDistinctByIdGiay(uuid);
    }

    @Override
    public List<GiayDistinct> findGiayDistinctByMauSac(UUID idMauSac) {
        return giayDistinctRepository.listMauSac(idMauSac);
    }

    @Override
    public List<GiayDistinct> findGiayDistinctByBrand(UUID idBrand) {
        return giayDistinctRepository.listBrand(idBrand);
    }

    @Override
    public List<GiayDistinct> findGiayDistinctBySize(UUID idSize) {
        return giayDistinctRepository.listSize(idSize);
    }
}
