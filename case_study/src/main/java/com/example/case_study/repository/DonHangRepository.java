package com.example.case_study.repository;

import com.example.case_study.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {

    @Query(value = "SELECT SUM(tong_thanh_toan) FROM don_hang WHERE trang_thai_don_hang = 'Đã giao'",
            nativeQuery = true)
    BigDecimal tongDoanhThu();

    @Query(value = "SELECT DATE_FORMAT(ngay_dat_hang, '%Y-%m') AS thang, SUM(tong_thanh_toan) " +
            "FROM don_hang WHERE trang_thai_don_hang = 'Đã giao' " +
            "GROUP BY thang ORDER BY thang",
            nativeQuery = true)
    List<Object[]> doanhThuTheoThang();
}
