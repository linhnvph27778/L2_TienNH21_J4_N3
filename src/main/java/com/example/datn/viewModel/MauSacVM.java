package com.example.datn.viewModel;

import com.example.datn.entity.MauSac;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MauSacVM {
    private String Ma;
    private String Ten;
    private int TrangThai;
    public void loadFromEn(MauSac e){
        this.setMa(e.getMa());
        this.setTen(e.getTen());
        this.setTrangThai(e.getTrangThai());

    }

}
