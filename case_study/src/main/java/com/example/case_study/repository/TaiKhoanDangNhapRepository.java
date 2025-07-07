package com.example.case_study.repository;

import com.example.case_study.model.TaiKhoanDangNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanDangNhapRepository extends JpaRepository<TaiKhoanDangNhap, Integer> {


    Optional<TaiKhoanDangNhap> findByTenDangNhap(String tenDangNhap);
    boolean existsByTenDangNhap(String tenDangNhap);
}