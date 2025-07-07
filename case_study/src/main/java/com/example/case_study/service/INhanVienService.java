package com.example.case_study.service;

import com.example.case_study.model.NhanVien;

import java.util.List;
import java.util.Optional;

public interface INhanVienService {
    List<NhanVien> findAll();
    Optional<NhanVien> findById(Integer id);
    NhanVien save(NhanVien nhanVien);
    void deleteById(Integer id);
}
