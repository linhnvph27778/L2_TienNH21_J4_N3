package com.example.datn.repository;

import com.example.datn.entity.GiayDistinct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GiayDistinctRepository extends JpaRepository<GiayDistinct, UUID> {
}
