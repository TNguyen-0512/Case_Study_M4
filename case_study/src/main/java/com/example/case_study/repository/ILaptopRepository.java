package com.example.case_study.repository;

import com.example.case_study.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepository extends JpaRepository<Laptop, Long> {

    Page<Laptop> findByTenLaptopContainingIgnoreCase(String tenLaptop, Pageable pageable);

    // Tìm theo tên thương hiệu (dựa trên entity ThuongHieu)
    Page<Laptop> findByThuongHieu_TenThuongHieuContainingIgnoreCase(String tenThuongHieu, Pageable pageable);

    // Tìm theo tên laptop và tên thương hiệu
    Page<Laptop> findByTenLaptopContainingIgnoreCaseAndThuongHieu_TenThuongHieuContainingIgnoreCase(
            String tenLaptop, String tenThuongHieu, Pageable pageable);
}

