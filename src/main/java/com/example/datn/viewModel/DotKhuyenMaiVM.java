package com.example.datn.viewModel;

import com.example.datn.entity.DotKhuyenMai;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DotKhuyenMaiVM {
    private String MaKhuyenMai;
    private String TenKhuyenMai;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int TrangThai;
    private int SoLuong;
    private int PhanTram;
    private BigDecimal GiaTienGiam;
    private String LoaiKhuyenMai;
    private String MoTa;

    public void loadFromEn(DotKhuyenMai e){
        this.setMaKhuyenMai(e.getMaKhuyenMai());
        this.setTenKhuyenMai(e.getTenKhuyenMai());
        this.setNgayBatDau(e.getNgayBatDau());
        this.setNgayKetThuc(e.getNgayKetThuc());
        this.setTrangThai(e.getTrangThai());
        this.setSoLuong(e.getSoLuong());
        this.setPhanTram(e.getPhanTram());
        this.setGiaTienGiam(e.getGiaTienGiam());
        this.setLoaiKhuyenMai(e.getLoaiKhuyenMai());
        this.setMoTa(e.getMoTa());

    }
}
