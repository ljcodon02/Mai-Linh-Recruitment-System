package com.example.demo.controller;

import com.example.demo.dto.BangDiemDTO;
import com.example.demo.entity.DanhSachDen;
import com.example.demo.entity.UngVien;
import com.example.demo.entity.YeuCauHoTro;
import com.example.demo.repository.DanhSachDenRepository;
import com.example.demo.repository.UngVienRepository;
import com.example.demo.repository.YeuCauHoTroRepository;
import com.example.demo.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
@CrossOrigin(origins = "*")
public class UngVienController {

    @Autowired
    private UngVienRepository repository;

    @Autowired
    private SelectionService selectionService;

    @Autowired
    private YeuCauHoTroRepository hoTroRepository;

    @Autowired
    private DanhSachDenRepository danhSachDenRepository;

    // =========================================================
    // QUY TRÌNH CHÍNH (ĐĂNG KÝ & CHẤM ĐIỂM)
    // =========================================================

    @GetMapping("/all")
    public List<UngVien> getAll() {
        return repository.findAll();
    }

    @PostMapping("/submit")
    public String submitApplication(@RequestBody UngVien uv) {
        return selectionService.kiemTraHoSoBanDau(uv);
    }

    @PutMapping("/evaluate")
    public UngVien evaluate(@RequestBody BangDiemDTO bangDiem) {
        return selectionService.chamDiemChiTiet(bangDiem);
    }

    // =========================================================
    // XỬ LÝ TÀI XẾ TÁI KÝ, YÊU CẦU HỖ TRỢ VÀ SỔ ĐEN
    // =========================================================

    @GetMapping("/check-msnv")
    public ResponseEntity<String> checkMSNV(@RequestParam String msnv) {
        boolean coTrongSoDen = danhSachDenRepository.findByMsnv(msnv).isPresent();

        if (coTrongSoDen) {
            return ResponseEntity.badRequest().body("Bị chặn do MSNV nằm trong Sổ đen");
        }
        return ResponseEntity.ok("Hợp lệ");
    }

    @PostMapping("/request-callback")
    public ResponseEntity<String> requestCallback(@RequestBody YeuCauHoTro request) {
        hoTroRepository.save(request);
        return ResponseEntity.ok("Đã ghi nhận yêu cầu. Tổng đài sẽ liên hệ lại sớm nhất!");
    }

    @GetMapping("/callbacks")
    public List<YeuCauHoTro> layDanhSachHoTro() {
        return hoTroRepository.findAll();
    }

    // --- MỚI THÊM: API LẤY TOÀN BỘ DANH SÁCH ĐEN CHO HR ---
    @GetMapping("/blacklist")
    public List<DanhSachDen> layDanhSachDen() {
        return danhSachDenRepository.findAll();
    }
}