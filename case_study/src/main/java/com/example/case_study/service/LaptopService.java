package com.example.case_study.service;

import com.example.case_study.model.Laptop;
import com.example.case_study.repository.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LaptopService implements ILaptopService {

    @Autowired
    private ILaptopRepository laptopRepository;

    @Override
    public Page<Laptop> findAll(Pageable pageable) {
        return laptopRepository.findAll(pageable);
    }

    @Override
    public Laptop findById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public long countAll() {
        return laptopRepository.count();
    }

    @Override
    public Page<Laptop> findByTenLaptopContainingIgnoreCase(String tenLaptop, Pageable pageable) {
        return laptopRepository.findByTenLaptopContainingIgnoreCase(tenLaptop, pageable);
    }

    @Override
    public Page<Laptop> filterByTenLaptopAndThuongHieu(String tenLaptop, Integer thuongHieuId, Pageable pageable) {
        return laptopRepository.filterByTenLaptopAndThuongHieu(tenLaptop, thuongHieuId, pageable);
    }

}
