package com.example.case_study.service;

import com.example.case_study.model.VaiTro;

import java.util.List;
import java.util.Optional;

public interface IVaiTroService {
    List<VaiTro> findAll();
    Optional<VaiTro> findById(Integer id);
    VaiTro save(VaiTro vaiTro);
    void deleteById(Integer id);
}
