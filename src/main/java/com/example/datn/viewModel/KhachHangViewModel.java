package com.example.datn.viewModel;

import com.example.datn.entity.DiaChi;
import com.example.datn.entity.KhachHang;
import com.example.datn.entity.LoaiKhachHang;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KhachHangViewModel {

    @NotBlank(message = "Khong được bỏ trống")
    private String ma;

    @NotBlank(message = "Khong được bỏ trống")
    private String hoTen;

    @NotNull(message = "Khong được bỏ trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Ngày sinh kh đưuọc quá ngày hiện tại")
    private Date ngaySinh;

    @NotBlank(message = "Khong được bỏ trống")
    private String email;

    @NotBlank(message = "Khong được bỏ trống")
    @Pattern(regexp = "0[0-9]{9}",message = "SDT khong dung định dạng")
    private String sdt;

    @NotNull(message = "Khong được bỏ trống")
    private int trangThai;

    @NotNull(message = "Khong được bỏ trống")
    private String pass;

    @NotNull(message = "Khong được bỏ trống")
    @Min(value = 1,message = "Lơn hơn 0")
    private int soLanMua;

    private LoaiKhachHang loaiKhachHang;

//    private DiaChi diaChi;

    public void loadFromEntity(KhachHang khachHang){
        this.setMa(khachHang.getMa());
        this.setHoTen(khachHang.getHoTen());
        this.setNgaySinh(khachHang.getNgaySinh());
        this.setSdt(khachHang.getSdt());
        this.setTrangThai(khachHang.getTrangThai());
        this.setEmail(khachHang.getEmail());
        this.setPass(khachHang.getPass());
        this.setSoLanMua(khachHang.getSoLanMua());
        this.setLoaiKhachHang(khachHang.getLoaiKhachHang());
//        this.setDiaChi(khachHang.getDiaChi());
    }

}
