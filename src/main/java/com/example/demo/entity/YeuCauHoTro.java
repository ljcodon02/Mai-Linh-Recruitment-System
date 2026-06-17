package com.example.demo.entity;

import jakarta.persistence.*; // Nếu dùng Spring Boot 2 thì là javax.persistence.*

@Entity
@Table(name = "yeu_cau_ho_tro")
public class YeuCauHoTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Hệ thống tự động đánh số thứ tự 1, 2, 3...

    private String hoTen;
    private String soCCCD;
    private String soDienThoai;
    private String msnv;

    // Thêm trường trạng thái để HR biết ca này đã gọi điện hay chưa
    private String trangThai = "CHUA_XU_LY";

    // --- GETTER & SETTER ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getSoCCCD() { return soCCCD; }
    public void setSoCCCD(String soCCCD) { this.soCCCD = soCCCD; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getMsnv() { return msnv; }
    public void setMsnv(String msnv) { this.msnv = msnv; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}