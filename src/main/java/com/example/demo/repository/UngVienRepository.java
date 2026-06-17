package com.example.demo.repository;

import com.example.demo.entity.UngVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UngVienRepository extends JpaRepository<UngVien, Long> {

}
