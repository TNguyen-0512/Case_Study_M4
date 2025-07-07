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
    public Page<Laptop> findByTenLaptopContaining(String tenLaptop, Pageable pageable) {
        return laptopRepository.findByTenLaptopContainingIgnoreCase(tenLaptop, pageable);
    }

    @Override
    public Page<Laptop> findByThuongHieuTenContaining(String tenThuongHieu, Pageable pageable) {
        return laptopRepository.findByThuongHieu_TenThuongHieuContainingIgnoreCase(tenThuongHieu, pageable);
    }

    @Override
    public Page<Laptop> findByTenLaptopAndThuongHieu(String tenLaptop, String tenThuongHieu, Pageable pageable) {
        return laptopRepository.findByTenLaptopContainingIgnoreCaseAndThuongHieu_TenThuongHieuContainingIgnoreCase(
                tenLaptop, tenThuongHieu, pageable);
    }

    @Override
    public Page<Laptop> filterLaptops(String tenLaptop,
                                      Integer thuongHieuId,
                                      BigDecimal giaMin,
                                      BigDecimal giaMax,
                                      String cpu,
                                      String ram,
                                      String oCung,
                                      Pageable pageable) {

        // Nếu rỗng thì truyền null, nếu có thì thêm dấu %
        String tenLaptopLike = (tenLaptop == null || tenLaptop.isBlank()) ? null : "%" + tenLaptop.trim().toLowerCase() + "%";
        String cpuLike = (cpu == null || cpu.isBlank()) ? null : "%" + cpu.trim() + "%";
        String ramLike = (ram == null || ram.isBlank()) ? null : "%" + ram.trim() + "%";
        String oCungLike = (oCung == null || oCung.isBlank()) ? null : "%" + oCung.trim() + "%";

        return laptopRepository.filterLaptops(
                tenLaptopLike,
                thuongHieuId,
                giaMin,
                giaMax,
                cpuLike,
                ramLike,
                oCungLike,
                pageable
        );
    }

}
