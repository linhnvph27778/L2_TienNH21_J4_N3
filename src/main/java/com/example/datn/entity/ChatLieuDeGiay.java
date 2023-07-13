package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChatLieuDeGiay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuDeGiay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Vui lòng nhập mã")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Vui lòng nhập tên")
    private String ten;

    @Column(name = "TrangThai")
    private int trangThai;
}
