package com.example.datn.entity;

import com.example.datn.viewModel.LoaiKhachHangViewModel;
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
@Table(name = "LoaiKhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiKhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma",unique = true)
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SoDiem")
    private int soDiem;

    public void loadFromVM(LoaiKhachHangViewModel LoaiKhachHangViewModel){
        this.setMa(LoaiKhachHangViewModel.getMa());
        this.setTen(LoaiKhachHangViewModel.getTen());
        this.setSoDiem(LoaiKhachHangViewModel.getSoDiem());
    }
}
