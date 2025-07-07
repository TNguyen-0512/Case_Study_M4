package com.example.case_study.service;

import com.example.case_study.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DonHangService implements IDonHangService {

    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public BigDecimal tongDoanhThu() {
        return donHangRepository.tongDoanhThu();
    }

    @Override
    public List<Object[]> doanhThuTheoThang() {
        return donHangRepository.doanhThuTheoThang();
    }
}
