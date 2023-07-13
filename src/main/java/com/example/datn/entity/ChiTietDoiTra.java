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
@Table(name = "ChiTietDoiTra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDoiTra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "NgayDoi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDoi;

    @Column(name = "NgayTraDuKien")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTraDuKien;

    @Column(name = "SoLuong")
    private int soLuong;


    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "idPhieuDoiTra")
    private PhieuDoiTra phieuDoiTra;
}
