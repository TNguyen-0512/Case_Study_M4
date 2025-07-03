package com.example.case_study.service;

import com.example.case_study.repository.ChiTietNhapKhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietNhapKhoService implements IChiTietNhapKhoService {

    @Autowired
    private ChiTietNhapKhoRepository chiTietNhapKhoRepository;

    @Override
    public List<Object[]> soLuongNhapTheoLaptop() {
        return chiTietNhapKhoRepository.soLuongNhapTheoLaptop();
    }

    @Override
    public List<Object[]> soLuongNhapTheoThang() {
        return chiTietNhapKhoRepository.soLuongNhapTheoThang();
    }
}
