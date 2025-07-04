package com.example.case_study.service;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILaptopService {
     Page<Laptop> findAll(Pageable pageable);
     Laptop findById(Long id);
     void save(Laptop laptop);
     void delete(Long id);
     long countAll();
     Page<Laptop> findByTenLaptopContaining(String tenLaptop, Pageable pageable);
     Page<Laptop> findByThuongHieuTenContaining(String tenThuongHieu, Pageable pageable);
     Page<Laptop> findByTenLaptopAndThuongHieu(String tenLaptop, String tenThuongHieu, Pageable pageable);
}

