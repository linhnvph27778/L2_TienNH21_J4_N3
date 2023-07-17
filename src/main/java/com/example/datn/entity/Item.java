package com.example.datn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Item {
    private UUID idChiTietGiay;
    private String maGiay;
    private String tenGiay;
    private String hinhAnh;
    private String mauSac;
    private int size;
    private String hang;
    private int soLuong;
    private double giaBan;
}
