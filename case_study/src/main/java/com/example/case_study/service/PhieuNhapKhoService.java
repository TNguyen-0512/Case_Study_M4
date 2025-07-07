package com.example.case_study.service;

import com.example.case_study.model.PhieuNhapKho;
import com.example.case_study.repository.PhieuNhapKhoRepository;
import com.example.case_study.service.IPhieuNhapKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuNhapKhoService implements IPhieuNhapKhoService {

    @Autowired
    private PhieuNhapKhoRepository phieuNhapKhoRepository;

    @Override
    public List<PhieuNhapKho> findAll() {
        return phieuNhapKhoRepository.findAll();
    }

    @Override
    public Optional<PhieuNhapKho> findById(Integer id) {
        return phieuNhapKhoRepository.findById(id);
    }

    @Override
    public PhieuNhapKho save(PhieuNhapKho phieuNhapKho) {
        return phieuNhapKhoRepository.save(phieuNhapKho);
    }

    @Override
    public void deleteById(Integer id) {
        phieuNhapKhoRepository.deleteById(id);
    }
}
