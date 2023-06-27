package com.example.datn.service;

import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.entity.ChatLieuThanGiay;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ThanGiayService {
    List<ChatLieuThanGiay> getAll();

    void add(ChatLieuThanGiay chatLieuThanGiay);

    void delete(ChatLieuThanGiay chatLieuThanGiay);

    Optional<ChatLieuThanGiay> getOne(UUID ma);
}
