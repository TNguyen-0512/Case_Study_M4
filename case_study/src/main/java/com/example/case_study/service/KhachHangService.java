package com.example.case_study.service;

import com.example.case_study.model.KhachHang;
import com.example.case_study.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> findById(Integer id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang save(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteById(Integer id) {
        khachHangRepository.deleteById(id);
    }
}
