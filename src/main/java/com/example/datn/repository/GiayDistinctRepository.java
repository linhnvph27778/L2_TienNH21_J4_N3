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

}
