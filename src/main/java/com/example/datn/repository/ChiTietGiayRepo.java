package com.example.datn.repository;

import com.example.datn.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietGiayRepo extends JpaRepository<ChiTietGiay, UUID> {

    List<ChiTietGiay> findByGiayId(UUID idGiay);



    @Query("SELECT DISTINCT g.mauSac FROM ChiTietGiay g WHERE g.giay.id = ?1")
    List<MauSac> findDistinctMauSac(UUID idGiay);

    @Query("SELECT DISTINCT g.mauSac FROM ChiTietGiay g WHERE g.giay.id = ?1 AND g.size.id = ?2")
    List<MauSac> findDistinctMauSacBySizeAndGiay(UUID idGiay, UUID idSize);

    @Query("SELECT DISTINCT g.size FROM ChiTietGiay g WHERE g.giay.id = ?1")
    List<Size> findDistinctSize(UUID idGiay);

    @Query("SELECT DISTINCT g.chatLieuDeGiay FROM ChiTietGiay g WHERE g.giay.id = ?1")
    List<ChatLieuDeGiay> findDistinctCLDG(UUID idGiay);

    @Query("SELECT DISTINCT g.chatLieuThanGiay FROM ChiTietGiay g WHERE g.giay.id = ?1")
    List<ChatLieuThanGiay> findDistinctCLTG(UUID idGiay);

    List<ChiTietGiay> findByGiayAndSize(Giay giay, Size size);



}
