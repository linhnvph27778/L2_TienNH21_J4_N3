package com.example.datn.entity;

import com.example.datn.viewModel.KhuyenMaiChiTietVM;
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

import java.util.UUID;

@Entity
@Table(name = "KhuyenMaiChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMaiChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "idDotKhuyenMai")
    private DotKhuyenMai dotKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "idChiTietGiay")
    private ChiTietGiay chiTietGiay;

    public void loadFromVM(KhuyenMaiChiTietVM e){
        this.setTrangThai(e.getTrangThai());

    }
}
