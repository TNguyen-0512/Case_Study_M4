package com.example.case_study.service;

import com.example.case_study.model.ChiTietNhapKho;
import com.example.case_study.repository.ChiTietNhapKhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ChiTietNhapKho> findAll() {
        return chiTietNhapKhoRepository.findAll();
    }

    @Override
    public Optional<ChiTietNhapKho> findById(Integer id) {
        return chiTietNhapKhoRepository.findById(id);
    }

    @Override
    public ChiTietNhapKho save(ChiTietNhapKho chiTietNhapKho) {
        return chiTietNhapKhoRepository.save(chiTietNhapKho);
    }

    @Override
    public void deleteById(Integer id) {
        chiTietNhapKhoRepository.deleteById(id);
    }
}
