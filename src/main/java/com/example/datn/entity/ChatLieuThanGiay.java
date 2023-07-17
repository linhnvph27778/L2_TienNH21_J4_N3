package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChatLieuThanGiay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuThanGiay {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "vui lòng nhập Mã")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "vui lòng nhập Tên")
    private String ten;

    @Column(name = "TrangThai")
    private int trangThai;
}
