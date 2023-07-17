package com.example.datn.entity;


import jakarta.persistence.*;
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

    private Integer remindProducts;

    @OneToOne
    @JoinColumn(name = "idHinhAnh")
    private HinhAnh hinhAnh;

    @OneToOne
    @JoinColumn(name = "idGiay")
    private Giay giay;

}
