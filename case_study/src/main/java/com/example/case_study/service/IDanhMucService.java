package com.example.case_study.service;

import com.example.case_study.model.DanhMuc;

import java.util.List;
import java.util.Optional;

public interface IDanhMucService {
    List<DanhMuc> findAll();
    Optional<DanhMuc> findById(Integer id);
    DanhMuc save(DanhMuc danhMuc);
    void deleteById(Integer id);
}
