package com.example.datn.repository;

import com.example.datn.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, UUID> {

    List<MauSac> findByTrangThai(int trangThai);
}
