package com.example.demo.repository;

import com.example.demo.entity.YeuCauHoTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeuCauHoTroRepository extends JpaRepository<YeuCauHoTro, Long> {
    // Để trống, Spring Boot sẽ tự động viết các hàm save(), findAll() ngầm bên dưới
}