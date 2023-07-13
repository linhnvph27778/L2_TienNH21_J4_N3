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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PhieuDoiTra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuDoiTra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "NgayBatDau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;

    @Column(name = "HinhThuc")
    private int hinhThuc;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "LiDo")
    private String liDo;

    @ManyToOne
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idNhanVien")
    private NhanVien nhanVien;
}
