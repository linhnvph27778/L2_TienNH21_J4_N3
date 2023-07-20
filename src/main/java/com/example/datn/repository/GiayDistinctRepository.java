package com.example.datn.repository;

import com.example.datn.entity.GiayDistinct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GiayDistinctRepository extends JpaRepository<GiayDistinct, UUID> {

    Page<GiayDistinct> findAllByOrderByMinPriceAsc(Pageable pageable);

    Page<GiayDistinct> findAllByOrderByMinPriceDesc(Pageable pageable);
}
