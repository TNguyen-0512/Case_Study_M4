package com.example.case_study.service;

import com.example.case_study.model.DonHang;

import java.math.BigDecimal;
import java.util.List;

public interface IDonHangService {
    BigDecimal tongDoanhThu();
    List<Object[]> doanhThuTheoThang();
    List<DonHang> findByKhachHangId(Integer idKhachHang);
    DonHang save(DonHang donHang);


}
