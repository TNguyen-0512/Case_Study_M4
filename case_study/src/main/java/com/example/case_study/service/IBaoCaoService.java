package com.example.case_study.service;

import java.math.BigDecimal;
import java.util.Map;

public interface IBaoCaoService {
    BigDecimal tongDoanhThu();
    Map<String, BigDecimal> doanhThuTheoThang();
    Map<String, BigDecimal> doanhThuTheoNam();
}
