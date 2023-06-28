package com.example.datn.service.impl;

import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.repository.CLDeGiayRep;
import com.example.datn.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeGiayServiceimpl implements DeGiayService {
    @Autowired
    private CLDeGiayRep clDeGiayRep;

    @Override
    public List<ChatLieuDeGiay> getAll() {

        return clDeGiayRep.findAll();
    }

    @Override
    public void add(ChatLieuDeGiay chatLieuDeGiay) {
        clDeGiayRep.save(chatLieuDeGiay);
    }

    @Override
    public void delete(ChatLieuDeGiay chatLieuDeGiay) {
        clDeGiayRep.delete(chatLieuDeGiay);
    }


    @Override
    public Optional<ChatLieuDeGiay> getOne(UUID id) {
        return clDeGiayRep.findById(id);
    }
}
