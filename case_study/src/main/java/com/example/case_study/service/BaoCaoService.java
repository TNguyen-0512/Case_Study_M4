package com.example.case_study.service;

import com.example.case_study.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaoCaoService implements IBaoCaoService {

    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public BigDecimal tongDoanhThu() {
        return donHangRepository.tongDoanhThu() != null ? donHangRepository.tongDoanhThu() : BigDecimal.ZERO;
    }

    @Override
    public Map<String, BigDecimal> doanhThuTheoThang() {
        List<Object[]> results = donHangRepository.doanhThuTheoThang();
        Map<String, BigDecimal> map = new LinkedHashMap<>();
        for (Object[] row : results) {
            String thang = (String) row[0];
            BigDecimal tong = (BigDecimal) row[1];
            map.put(thang, tong);
        }
        return map;
    }

    @Override
    public Map<String, BigDecimal> doanhThuTheoNam() {
        List<Object[]> results = donHangRepository.doanhThuTheoNam();
        Map<String, BigDecimal> map = new LinkedHashMap<>();
        for (Object[] row : results) {
            String nam = String.valueOf(row[0]);
            BigDecimal tong = (BigDecimal) row[1];
            map.put(nam, tong);
        }
        return map;
    }
}
