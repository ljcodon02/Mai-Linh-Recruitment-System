package com.example.demo.repository;

import com.example.demo.entity.DanhSachDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DanhSachDenRepository extends JpaRepository<DanhSachDen, Long> {
    // Lệnh này tương đương với: SELECT * FROM danh_sach_den WHERE msnv = ?
    Optional<DanhSachDen> findByMsnv(String msnv);
}