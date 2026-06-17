package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ung_vien")
@Data
public class UngVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hoTen;

    @Column(unique = true)
    private String soCCCD;

    // ĐÃ SỬA CHỮ 'int' THÀNH 'Integer' ĐỂ CHẤP NHẬN GIÁ TRỊ NULL
    private Integer tuoi;

    private String loaiBangLai;
    private boolean datSucKhoe;

    private boolean trangThaiTaiKy;
    private String msnv;

    private double diemThucHanh;
    private String trangThai;
}