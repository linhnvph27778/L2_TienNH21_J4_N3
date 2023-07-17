package com.example.datn.service.Impl;

import com.example.datn.entity.GiayDistinct;
import com.example.datn.repository.GiayDistinctRepository;
import com.example.datn.service.GiayDistinctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiayDistinceServiceImpls implements GiayDistinctService {

    @Autowired
    private GiayDistinctRepository giayDistinctRepository;

    @Override
    public List<GiayDistinct> getAllGiayDistince() {
        return giayDistinctRepository.findAll();
    }
}
