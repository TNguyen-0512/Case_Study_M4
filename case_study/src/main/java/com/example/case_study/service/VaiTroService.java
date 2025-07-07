package com.example.case_study.service;

import com.example.case_study.model.VaiTro;
import com.example.case_study.repository.VaiTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaiTroService {

    @Autowired
    private VaiTroRepository vaiTroRepository;

    public VaiTro findByTenVaiTro(String tenVaiTro) {
        return vaiTroRepository.findByTenVaiTro(tenVaiTro);
    }
}