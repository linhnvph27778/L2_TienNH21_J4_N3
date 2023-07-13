package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "DiaChi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Xa")
    private String xa;

    @Column(name = "huyen")
    private String huyen;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuacGia")
    private String quocGia;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "SdtNhan")
    private String sdtNhan;
}
