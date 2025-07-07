package com.example.case_study.repository;

import com.example.case_study.model.TaiKhoanDangNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaiKhoanDangNhapRepository extends JpaRepository<TaiKhoanDangNhap, Integer> {
    @Query("SELECT t FROM TaiKhoanDangNhap t WHERE UPPER(t.tenDangNhap) = UPPER(:tenDangNhap)")
    Optional<TaiKhoanDangNhap> findByTenDangNhap(@Param("tenDangNhap") String tenDangNhap);

}
