package com.example.demo.service;

import com.example.demo.dto.BangDiemDTO;
import com.example.demo.entity.UngVien;
import com.example.demo.repository.DanhSachDenRepository;
import com.example.demo.repository.UngVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionService {

    @Autowired
    private UngVienRepository repository;

    @Autowired
    private DanhSachDenRepository danhSachDenRepository;

    // --- KIỂM TRA HỒ SƠ ĐẦU VÀO VÀ ĐỐI CHIẾU SỔ ĐEN ---
    public String kiemTraHoSoBanDau(UngVien uv) {
        // Double-check bằng DB thật
        if (uv.isTrangThaiTaiKy() && uv.getMsnv() != null) {
            boolean coTrongSoDen = danhSachDenRepository.findByMsnv(uv.getMsnv()).isPresent();
            if (coTrongSoDen) {
                uv.setTrangThai("LOAI");
                repository.save(uv);
                return "Hồ sơ bị loại do phát hiện vi phạm cũ trong hệ thống Mai Linh!";
            }
        }

        uv.setTrangThai("CHO_PHONG_VAN");
        repository.save(uv);
        return "Hồ sơ hợp lệ! Đã chuyển vào danh sách chờ sát hạch.";
    }

    // --- TÍNH ĐIỂM SA HÌNH TỪ DTO ---
    public UngVien chamDiemChiTiet(BangDiemDTO dto) {
        UngVien uv = repository.findById(dto.getIdUngVien()).orElse(null);
        if (uv == null) return null;

        // Nếu dính lỗi loại trực tiếp (Đình chỉ thi)
        if (dto.isLoiTrucTiep()) {
            uv.setDiemThucHanh(0);
            uv.setTrangThai("LOAI");
            return repository.save(uv);
        }

        // Máy tính điểm: 10 trừ đi tổng số lỗi tương ứng
        double diemTong = 10.0 - (dto.getLoiTru05() * 0.5)
                - (dto.getLoiTru10() * 1.0)
                - (dto.getLoiTru15() * 1.5)
                - (dto.getLoiTru20() * 2.0);

        if (diemTong < 0) diemTong = 0; // Điểm không được âm

        uv.setDiemThucHanh(diemTong);

        // Chốt Đạt / Loại
        if (diemTong >= 5.0) {
            uv.setTrangThai("DAT");
        } else {
            uv.setTrangThai("LOAI");
        }

        return repository.save(uv);
    }
}