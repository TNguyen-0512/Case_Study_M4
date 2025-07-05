package com.example.case_study.service;

import com.example.case_study.model.DanhMuc;
import com.example.case_study.repository.DanhMucRepository;
import com.example.case_study.service.IDanhMucService;
import com.example.case_study.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucService implements IDanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public Optional<DanhMuc> findById(Integer id) {
        return danhMucRepository.findById(id);
    }

    @Override
    public DanhMuc save(DanhMuc danhMuc) {
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public void deleteById(Integer id) {
        danhMucRepository.deleteById(id);
    }
}
