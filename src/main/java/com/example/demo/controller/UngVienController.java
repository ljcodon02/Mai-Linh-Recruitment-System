package com.example.demo.controller;

import com.example.demo.entity.UngVien;
import com.example.demo.repository.UngVienRepository;
import com.example.demo.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 1. Lấy danh sách tất cả ứng viên
    @GetMapping("/all")
    public List<UngVien> getAll() {
        return repository.findAll();
    }

    // 2. Tiếp nhận hồ sơ mới (Bước 3 trong quy trình)
    @PostMapping("/submit")
    public String submitApplication(@RequestBody UngVien uv) {
        return selectionService.kiemTraHoSoBanDau(uv);
    }

    // 3. Chấm điểm và xét duyệt (Bước 4 trong quy trình)
    @PutMapping("/evaluate/{id}")
    public UngVien evaluate(@PathVariable Long id,
                            @RequestParam int chetMay,
                            @RequestParam int lonSo,
                            @RequestParam boolean loaiTrucTiep) {
        return selectionService.chamDiemVaXetDuyet(id, chetMay, lonSo, loaiTrucTiep);
    }
}