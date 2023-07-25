package com.example.datn.repository;

import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
    @Query(value = "select ChiTietGiay.Id , ChiTietGiay.GiaBan,hoadonchitiet.soluong, giay.ten ,hinhanh.URLImg0 ,Size.soSize,MauSac.ten,Hang.Ten\n" +
            "from hoadonchitiet join chitietgiay on hoadonchitiet.idChiTietGiay= ChiTietGiay.id\n" +
            "join giay on giay.id = ChiTietGiay.idGiay  \n" +
            "join hinhanh on hinhanh.id = ChiTietGiay.idhinhanh \n" +
            "join Size on Size.Id = ChiTietGiay.idSize\n" +
            "join MauSac on MauSac.id = ChiTietGiay.idMauSac\n" +
            "join Hang on Hang.Id= ChiTietGiay.idHang " +
            "where idhoadon = ?1",nativeQuery = true)
    List<ChiTietGiay> listHoaDonCho(UUID idHoaDon);
}
