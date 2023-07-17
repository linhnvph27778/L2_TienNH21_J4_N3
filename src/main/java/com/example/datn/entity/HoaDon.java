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
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayNhan;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @Column(name = "HinhThucThanhToan")
    private int hinhThucThanhToan;

    @ManyToOne
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idNhanVien")
    private NhanVien nhanVien;
}
