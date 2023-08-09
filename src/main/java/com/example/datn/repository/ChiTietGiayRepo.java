package com.example.datn.repository;

import com.example.datn.entity.ChatLieuDeGiay;
import com.example.datn.entity.ChatLieuThanGiay;
import com.example.datn.entity.ChiTietGiay;
import com.example.datn.entity.Giay;
import com.example.datn.entity.Item;
import com.example.datn.entity.MauSac;
import com.example.datn.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    ChiTietGiay findChiTietGiayById(UUID id);

    List<ChiTietGiay> findChiTietGiayByGiayAndSize(Giay giay, Size size);

    List<ChiTietGiay> findByGiayAndTrangThaiOrderBySizeDesc(Giay giay, int trangThai);

    //
    @Query(value = "select ChiTietGiay.Id,Giay.Ma,Giay.Ten ,HinhAnh.URLImg0,MauSac.ten,Size.SoSize,Hang.ten,HoaDonChiTiet.SoLuong,hoadonchitiet.DonGia\n" +
            "from ChiTietGiay join HoaDonChiTiet on ChiTietGiay.Id= HoaDonChiTiet.idChiTietGiay\n" +
            "join hoadon on hoadon.id= hoadonchitiet.idhoadon\n" +
            "join Size on Size.Id= ChiTietGiay.idSize\n" +
            "join giay on giay.id = ChiTietGiay.idGiay  \n" +
            "join hinhanh on hinhanh.id = ChiTietGiay.idhinhanh \n" +
            "join MauSac on MauSac.id = ChiTietGiay.idMauSac\n" +
            "join Hang on Hang.Id= ChiTietGiay.idHang\n" +
            "where hoadon.id =:idHoaDon ",nativeQuery = true)
    List<Item> listHoaDonCho(@Param("idHoaDon")UUID idHoaDon);

}
