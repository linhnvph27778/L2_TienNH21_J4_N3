package com.example.datn.viewModel;

import com.example.datn.entity.KhuyenMaiChiTiet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMaiChiTietVM {
    private int TrangThai;
    private UUID dotKhuyenMai;
    private UUID chiTietGiay;

    public void loadFromEn(KhuyenMaiChiTiet e){
        this.setTrangThai(e.getTrangThai());
        this.setDotKhuyenMai(e.getDotKhuyenMai().getId());
        this.setChiTietGiay(e.getChiTietGiay().getId());
    }
}
