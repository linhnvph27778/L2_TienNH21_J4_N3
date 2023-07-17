package com.example.datn.service;

import com.example.datn.entity.GiayDistinct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiayDistinctService {

    List<GiayDistinct> getAllGiayDistince();
}
