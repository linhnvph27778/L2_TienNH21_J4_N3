package com.example.datn.repository;

import com.example.datn.entity.GiayDistinct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GiayDistinctRepository extends JpaRepository<GiayDistinct, UUID> {

    Page<GiayDistinct> findAllByOrderByMinPriceAsc(Pageable pageable);

    Page<GiayDistinct> findAllByOrderByMinPriceDesc(Pageable pageable);

    @Query(value = "select GiayDistinct.id,GiayDistinct.idHinhAnh,GiayDistinct.idGiay,GiayDistinct.minPrice,GiayDistinct.maxPrice, GiayDistinct.remindProducts,GiayDistinct.nameBrand" +
            " from GiayDistinct join Giay on GiayDistinct.idGiay=Giay.id  where" +
            " (Giay.Ten like %?1% or ?1 is null or ?1 like '') and " +
            " (minPrice >= ?2 or ?2 is null ) and " +
            "(minPrice <= ?3 or ?3 is null )", nativeQuery = true)
    List<GiayDistinct> timKiem(String keyword, double giaMin,double giaMax);

    @Query(value = "select GiayDistinct.id,GiayDistinct.idHinhAnh,GiayDistinct.idGiay,GiayDistinct.minPrice,GiayDistinct.maxPrice, GiayDistinct.remindProducts,GiayDistinct.nameBrand, Size.soSize " +
                    " from GiayDistinct join giay on GiayDistinct.idGiay= Giay.id\n" +
                    " join chitietgiay on Giay.id = chitietgiay.idGiay\n" +
                    " join size on chitietgiay.idsize = size.id \n" +
                    " where GiayDistinct.idgiay= ?1 ",nativeQuery = true)
    List<GiayDistinct> soSize(UUID idGiay);
    @Query(value = "select * from GiayDistinct where idGiay = ?1",nativeQuery = true)
    GiayDistinct findGiayDistinctByIdGiay(UUID id);

    @Query(value = "select GiayDistinct.id,GiayDistinct.MinPrice,GiayDistinct.maxprice, \n" +
            "GiayDistinct.nameBrand,GiayDistinct.remindProducts,GiayDistinct.idGiay,GiayDistinct.idHinhAnh \n" +
            "from GiayDistinct join Giay \n" +
            "on GiayDistinct.IdGiay = Giay.Id \n" +
            "join ChiTietGiay on Giay.Id = ChiTietGiay.IdGiay \n" +
            "join MauSac on ChiTietGiay.IdMauSac = MauSac.id  \n" +
            "where MauSac.id = ?1", nativeQuery = true)
    List<GiayDistinct> listMauSac(UUID idMauSac);

    @Query(value = "select GiayDistinct.id,GiayDistinct.MinPrice,GiayDistinct.maxprice, \n" +
            "GiayDistinct.nameBrand,GiayDistinct.remindProducts,GiayDistinct.idGiay,GiayDistinct.idHinhAnh \n" +
            "from GiayDistinct join Giay \n" +
            "on GiayDistinct.IdGiay = Giay.Id \n" +
            "join ChiTietGiay on Giay.Id = ChiTietGiay.IdGiay \n" +
            "join Size on ChiTietGiay.IdSize = Size.id  \n" +
            "where Size.id = ?1", nativeQuery = true)
    List<GiayDistinct> listSize(UUID idSize);

    @Query(value = "select GiayDistinct.id,GiayDistinct.MinPrice,GiayDistinct.maxprice, \n" +
            "GiayDistinct.nameBrand,GiayDistinct.remindProducts,GiayDistinct.idGiay,GiayDistinct.idHinhAnh \n" +
            "from GiayDistinct join Giay \n" +
            "on GiayDistinct.IdGiay = Giay.Id \n" +
            "join ChiTietGiay on Giay.Id = ChiTietGiay.IdGiay \n" +
            "join Hang on ChiTietGiay.IdHang = Hang.id  \n" +
            "where Hang.id = ?1", nativeQuery = true)
    List<GiayDistinct> listBrand(UUID idBrand);
}
