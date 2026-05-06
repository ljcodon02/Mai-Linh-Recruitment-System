package com.example.demo.service;

import com.example.demo.entity.UngVien;
import com.example.demo.repository.UngVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionService {

    @Autowired
    private UngVienRepository repository;

    public String kiemTraHoSoBanDau(UngVien uv) {
        if (uv.isTrangThaiTaiKy() && (uv.isNoCongNo() || uv.isViPhamNhanThan())) {
            uv.setTrangThai("LOAI");
            repository.save(uv);
            return "Hồ sơ bị loại!";
        }
        uv.setTrangThai("CHO_PHONG_VAN");
        repository.save(uv);
        return "Hồ sơ hợp lệ!";
    }

    public UngVien chamDiemVaXetDuyet(Long id, int chetMay, int lonSo, boolean loaiTrucTiep) {
        UngVien uv = repository.findById(id).orElseThrow();
        double diem = 10.0 - (chetMay * 0.5) - (lonSo * 0.5);
        uv.setDiemThucHanh(diem);
        uv.setTrangThai((diem >= 5 && !loaiTrucTiep) ? "DAT" : "LOAI");
        return repository.save(uv);
    }
}
