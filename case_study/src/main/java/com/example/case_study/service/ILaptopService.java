package com.example.case_study.service;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ILaptopService {
     Page<Laptop> findAll(Pageable pageable);
     Laptop findById(Long id);
     void save(Laptop laptop);
     void delete(Long id);
     long countAll();
     Page<Laptop> findByTenLaptopContaining(String tenLaptop, Pageable pageable);
     Page<Laptop> findByThuongHieuTenContaining(String tenThuongHieu, Pageable pageable);
     Page<Laptop> findByTenLaptopAndThuongHieu(String tenLaptop, String tenThuongHieu, Pageable pageable);
    Page<Laptop> filterLaptops(String tenLaptop,Integer thuongHieuId, BigDecimal giaMin, BigDecimal giaMax, String cpu, String ram, String oCung, Pageable pageable);
}

