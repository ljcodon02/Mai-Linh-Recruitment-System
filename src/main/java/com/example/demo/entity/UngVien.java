package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ung_vien")
@Data // Cực kỳ quan trọng để nó tự đẻ ra hàm isNoCongNo()
public class UngVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hoTen;
    private String soCCCD;
    private String loaiBangLai;
    private boolean trangThaiTaiKy;

    // HAI DÒNG NÀY ĐANG THIẾU:
    private boolean noCongNo;
    private boolean viPhamNhanThan;

    private double diemThucHanh;
    private boolean datSucKhoe;
    private String trangThai;
}