package com.example.case_study.service;

import com.example.case_study.model.KhachHang;

import java.util.List;
import java.util.Optional;

public interface IKhachHangService {
    List<KhachHang> findAll();
    Optional<KhachHang> findById(Integer id);
    KhachHang save(KhachHang khachHang);
    void deleteById(Integer id);
}
