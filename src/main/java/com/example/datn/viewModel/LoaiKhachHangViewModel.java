package com.example.datn.viewModel;

import com.example.datn.entity.LoaiKhachHang;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LoaiKhachHangViewModel {
    @NotBlank(message = "Không được bỏ trông")
    private String ma;

    @NotBlank(message = "Không được bỏ trông")
    private String ten;

    @NotNull(message = "Không được bỏ trông")
    @Min(value = 1,message = "Phải lớn hơn 0")
    private int soDiem;

    public void loadFromEntity(LoaiKhachHang loaiKhachHang){
        this.setMa(loaiKhachHang.getMa());
        this.setTen(loaiKhachHang.getTen());
        this.setSoDiem(loaiKhachHang.getSoDiem());
    }
}
