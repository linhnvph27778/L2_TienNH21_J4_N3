package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "HinhAnh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "URLImg0")
    private String urlImg0;

    @Column(name = "URLImg1")
    private String urlImg1;

    @Column(name = "URLImg2")
    private String urlImg2;

    @Column(name = "URLImg3")
    private String urlImg3;

    @Column(name = "TrangThai")
    private int trangThai;
}
