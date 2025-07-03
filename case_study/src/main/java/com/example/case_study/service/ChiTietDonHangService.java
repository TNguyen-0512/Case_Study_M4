package com.example.case_study.service;

import com.example.case_study.repository.ChiTietDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietDonHangService implements IChiTietDonHangService {

    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public List<Object[]> soLuongXuatTheoLaptop() {
        return chiTietDonHangRepository.soLuongXuatTheoLaptop();
    }

    @Override
    public List<Object[]> soLuongXuatTheoThang() {
        return chiTietDonHangRepository.soLuongXuatTheoThang();
    }
}

