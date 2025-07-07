package com.example.case_study.service;

import com.example.case_study.model.DonHang;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IDonHangService {
    List<DonHang> findAll();
    Optional<DonHang> findById(Integer id);
    DonHang save(DonHang donHang);
    void deleteById(Integer id);

    // Báo cáo doanh thu
    BigDecimal tongDoanhThu();
    List<Object[]> doanhThuTheoThang();
}
