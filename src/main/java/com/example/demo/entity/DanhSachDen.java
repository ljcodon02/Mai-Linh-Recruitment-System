package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "danh_sach_den")
@Data
public class DanhSachDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String msnv; // Mã số nhân viên vi phạm

    private String hoTen;

    // --- SỐ HÓA 8 LỖI TỪ BIÊN BẢN BM261 ---
    private boolean loiGianLanTromCap;   // Trộm cắp, gian lận, chạy lòng vòng
    private boolean loiMaTuy;            // Tiền sử dương tính chất gây nghiện
    private boolean loiViPhamPhapLuat;   // Vi phạm pháp luật, gây rối trật tự
    private boolean loiHanhHung;         // Hành hung khách hàng/đồng nghiệp
    private boolean loiTuChoiCuoc;       // Từ chối cước dẫn đến khiếu nại
    private boolean loiDanhNhau;         // Tụ tập đánh nhau tại công ty
    private boolean loiCamCoXe;          // Cầm cố, thế chấp xe
    private boolean loiGiaoXeSaiQuyDinh; // Giao xe cho người khác

    private String loiKhac;              // Ghi chú thêm (nếu có)
}