package com.example.case_study.service;

import com.example.case_study.model.KhachHang;

public interface IKhachHangService {
    boolean existsByEmail(String email);
    KhachHang save(KhachHang khachHang);
    KhachHang findByUsername(String username);  // đổi tên cho đúng với controller
}
