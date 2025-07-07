package com.example.case_study.service;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ILaptopService {
    Page<Laptop> findAll(Pageable pageable);
    Laptop findById(Long id);
    void save(Laptop laptop);
    void delete(Long id);
    long countAll();
    Page<Laptop> findByTenLaptopContainingIgnoreCase(String tenLaptop, Pageable pageable);
    Page<Laptop> filterByTenLaptopAndThuongHieu(String tenLaptop, Integer thuongHieuId, Pageable pageable);
}
