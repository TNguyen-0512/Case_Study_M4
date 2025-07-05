package com.example.case_study.service;

import com.example.case_study.model.ChiTietNhapKho;

import java.util.List;
import java.util.Optional;

public interface IChiTietNhapKhoService {
    List<Object[]> soLuongNhapTheoLaptop();
    List<Object[]> soLuongNhapTheoThang();

    // CRUD
    List<ChiTietNhapKho> findAll();
    Optional<ChiTietNhapKho> findById(Integer id);
    ChiTietNhapKho save(ChiTietNhapKho chiTietNhapKho);
    void deleteById(Integer id);
}
