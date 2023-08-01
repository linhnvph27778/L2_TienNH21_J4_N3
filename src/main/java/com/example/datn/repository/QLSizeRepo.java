package com.example.datn.repository;

import com.example.datn.entity.GiayDistinct;
import com.example.datn.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QLSizeRepo extends JpaRepository<Size, UUID> {
    List<Size> findByTrangThaiOrderBySoSize(int trangThai);

    @Query(value = "select ChiTietGiay.idGiay, Size.id,Size.ma, Size.soSize, Size.trangThai from ChiTietGiay join Size \n" +
            "on Size.id = ChiTietGiay.idSize\n" +
            "where ChiTietGiay.idGiay=?1",nativeQuery = true)
    List<Size> sizeGiay(UUID idGiay);
}
