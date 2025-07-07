package com.example.case_study.service;

import com.example.case_study.model.DonHang;
import com.example.case_study.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DonHangService implements IDonHangService {

    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public List<DonHang> findAll() {
        return donHangRepository.findAll();
    }

    @Override
    public Optional<DonHang> findById(Integer id) {
        return donHangRepository.findById(id);
    }

    @Override
    public DonHang save(DonHang donHang) {
        return donHangRepository.save(donHang);
    }

    @Override
    public void deleteById(Integer id) {
        donHangRepository.deleteById(id);
    }

    @Override
    public BigDecimal tongDoanhThu() {
        return donHangRepository.tongDoanhThu();
    }

    @Override
    public List<Object[]> doanhThuTheoThang() {
        return donHangRepository.doanhThuTheoThang();
    }
}
