package com.example.datn.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "GiayDistinct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiayDistinct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Distinct;

    private Double minPrice;

    private Double maxPrice;

    private String nameBrand;

    private Integer remindProducts;

    @OneToOne
    @JoinColumn(name = "idHinhAnh")
    private HinhAnh hinhAnh;

    @OneToOne
    @JoinColumn(name = "idGiay")
    private Giay giay;

}
