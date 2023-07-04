package com.example.datn.service.impl;


import com.example.datn.entity.ChatLieuThanGiay;
import com.example.datn.repository.CLThanGiayRep;
import com.example.datn.service.ThanGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThanGiayServiceimpl implements ThanGiayService {
    @Autowired
    private CLThanGiayRep clThanGiayRep;


    @Override
    public List<ChatLieuThanGiay> getAll() {

        return clThanGiayRep.findAll();
    }

    @Override
    public void add(ChatLieuThanGiay chatLieuThanGiay) {
        clThanGiayRep.save(chatLieuThanGiay);
    }

    @Override
    public void delete(ChatLieuThanGiay chatLieuThanGiay) {
        clThanGiayRep.delete(chatLieuThanGiay);
    }

    @Override
    public Optional<ChatLieuThanGiay> getOne(UUID id) {
        return clThanGiayRep.findById(id);
    }
}
