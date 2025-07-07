package com.example.case_study.repository;

import com.example.case_study.model.ChiTietNhapKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietNhapKhoRepository extends JpaRepository<ChiTietNhapKho, Integer> {

    @Query(value = "SELECT l.ten_laptop, SUM(c.so_luong_nhap) " +
            "FROM chi_tiet_nhap_kho c JOIN laptop l ON c.id_laptop = l.id_laptop " +
            "GROUP BY l.ten_laptop ORDER BY SUM(c.so_luong_nhap) DESC",
            nativeQuery = true)
    List<Object[]> soLuongNhapTheoLaptop();

    @Query(value = "SELECT DATE_FORMAT(p.ngay_nhap, '%Y-%m') AS thang, SUM(c.so_luong_nhap) " +
            "FROM chi_tiet_nhap_kho c JOIN phieu_nhap_kho p ON c.id_phieu_nhap = p.id_phieu_nhap " +
            "GROUP BY thang ORDER BY thang",
            nativeQuery = true)
    List<Object[]> soLuongNhapTheoThang();
}
