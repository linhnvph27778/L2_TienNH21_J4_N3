package com.example.datn.repository;

import com.example.datn.entity.ChiTietGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietGiayRepo extends JpaRepository<ChiTietGiay, UUID> {

    List<ChiTietGiay> findByGiayId(UUID idGiay);
}
