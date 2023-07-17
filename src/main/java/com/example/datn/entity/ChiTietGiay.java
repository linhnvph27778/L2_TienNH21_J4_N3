package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietGiay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "NamBaoHanh")
    private int namBaoHanh;

    @Column(name = "NamSanXuat")
    private int namSanXuat;

    @Column(name = "TrongLuong")
    private double trongLuong;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "soLuongTon")
    private int soLuongTon;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "idHinhAnh")
    private HinhAnh hinhAnh;

    @ManyToOne
    @JoinColumn(name = "idChatLieuDeGiay")
    private ChatLieuDeGiay chatLieuDeGiay;

    @ManyToOne
    @JoinColumn(name = "idChatLieuThanGiay")
    private ChatLieuThanGiay chatLieuThanGiay;

    @ManyToOne
    @JoinColumn(name = "idHang")
    private Hang hang;

    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "idGiay")
    private Giay giay;
}
