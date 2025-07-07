package com.example.case_study.service;

import com.example.case_study.model.KhachHang;
import com.example.case_study.repository.KhachHangRepository;
import com.example.case_study.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public boolean existsByEmail(String email) {
        return khachHangRepository.existsByEmail(email);
    }

    @Override
    public KhachHang save(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang findByUsername(String username) {
        return khachHangRepository.findByTaiKhoan_TenDangNhap(username);
    }
}
