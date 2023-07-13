package com.example.datn.entity;

import com.example.datn.viewModel.KhachHangViewModel;
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
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @Column(name = "Email")
    private String email;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TrangThai")
    private int trangThai = 0;

    @Column(name = "Pass")
    private String pass;

    @Column(name = "SoLanMua")
    private int soLanMua = 0;

    @ManyToOne
    @JoinColumn(name = "idLoaiKhachHang")
    private LoaiKhachHang loaiKhachHang;

    @ManyToOne
    @JoinColumn(name = "idDiaChi")
    private DiaChi diaChi;

    public void loadFormViewModel(KhachHangViewModel KhachHangViewModel){
        this.setMa(KhachHangViewModel.getMa());
        this.setHoTen(KhachHangViewModel.getHoTen());
        this.setNgaySinh(KhachHangViewModel.getNgaySinh());
        this.setSdt(KhachHangViewModel.getSdt());
        this.setTrangThai(KhachHangViewModel.getTrangThai());
        this.setEmail(KhachHangViewModel.getEmail());
        this.setPass(KhachHangViewModel.getPass());
        this.setSoLanMua(KhachHangViewModel.getSoLanMua());
        this.setLoaiKhachHang(KhachHangViewModel.getLoaiKhachHang());
//        this.setDiaChi(KhachHangViewModel.getDiaChi());
    }
}
