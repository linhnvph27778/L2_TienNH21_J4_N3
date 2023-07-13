package com.example.datn.repository;

import com.example.datn.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HangRepo extends JpaRepository<Hang, UUID> {
    List<Hang> findByTrangThai(int tragThai);
}
