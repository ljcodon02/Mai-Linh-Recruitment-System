package com.example.demo.dto;

public class BangDiemDTO {
    private Long idUngVien;
    private int loiTru05; // Tổng số lần mắc các lỗi trừ 0.5 điểm
    private int loiTru10; // Tổng số lần mắc các lỗi trừ 1.0 điểm
    private int loiTru15; // Tổng số lần mắc các lỗi trừ 1.5 điểm
    private int loiTru20; // Tổng số lần mắc các lỗi trừ 2.0 điểm
    private boolean loiTrucTiep; // Đình chỉ thi

    // --- GETTER & SETTER ---
    public Long getIdUngVien() { return idUngVien; }
    public void setIdUngVien(Long idUngVien) { this.idUngVien = idUngVien; }

    public int getLoiTru05() { return loiTru05; }
    public void setLoiTru05(int loiTru05) { this.loiTru05 = loiTru05; }

    public int getLoiTru10() { return loiTru10; }
    public void setLoiTru10(int loiTru10) { this.loiTru10 = loiTru10; }

    public int getLoiTru15() { return loiTru15; }
    public void setLoiTru15(int loiTru15) { this.loiTru15 = loiTru15; }

    public int getLoiTru20() { return loiTru20; }
    public void setLoiTru20(int loiTru20) { this.loiTru20 = loiTru20; }

    public boolean isLoiTrucTiep() { return loiTrucTiep; }
    public void setLoiTrucTiep(boolean loiTrucTiep) { this.loiTrucTiep = loiTrucTiep; }
}