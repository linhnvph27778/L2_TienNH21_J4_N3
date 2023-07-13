package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Size")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
	@NotBlank(message = "Vui lòng nhập Mã")
    private String ma;

    //
    @Column(name = "soSize")
    private int soSize;

    @Column(name = "TrangThai")
    private int trangThai;

//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public String getMa() {
//		return ma;
//	}
//
//	public void setMa(String ma) {
//		this.ma = ma;
//	}
//
//	public int getSoSize() {
//		return soSize;
//	}
//
//	public void setSoSize(int soSize) {
//		this.soSize = soSize;
//	}
//
//	public int getTrangThai() {
//		return trangThai;
//	}
//
//	public void setTrangThai(int trangThai) {
//		this.trangThai = trangThai;
//	}
//
//
    
}
