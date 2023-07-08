package com.example.datn.service;

import com.example.datn.entity.ChatLieuDeGiay;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeGiayService {
    List<ChatLieuDeGiay> getAll();

    void add(ChatLieuDeGiay chatLieuDeGiay);

    void delete(ChatLieuDeGiay chatLieuDeGiay);

    Optional<ChatLieuDeGiay> getOne(UUID id);
}
