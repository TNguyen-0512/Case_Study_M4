package com.example.case_study.service;

import com.example.case_study.model.PhieuNhapKho;

import java.util.List;
import java.util.Optional;

public interface IPhieuNhapKhoService {
    List<PhieuNhapKho> findAll();
    Optional<PhieuNhapKho> findById(Integer id);
    PhieuNhapKho save(PhieuNhapKho phieuNhapKho);
    void deleteById(Integer id);
}
