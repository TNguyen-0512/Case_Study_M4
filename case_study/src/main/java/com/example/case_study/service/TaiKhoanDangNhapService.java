package com.example.case_study.service;

import com.example.case_study.model.TaiKhoanDangNhap;
import com.example.case_study.repository.TaiKhoanDangNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanDangNhapService {

    @Autowired
    private TaiKhoanDangNhapRepository taiKhoanRepository;

    public Optional<TaiKhoanDangNhap> findByTenDangNhap(String tenDangNhap) {
        return taiKhoanRepository.findByTenDangNhap(tenDangNhap);
    }

    public boolean existsByTenDangNhap(String tenDangNhap) {
        return taiKhoanRepository.existsByTenDangNhap(tenDangNhap);
    }

    public TaiKhoanDangNhap save(TaiKhoanDangNhap taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }
}