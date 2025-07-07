package com.example.case_study.repository;

import com.example.case_study.model.HinhAnhLaptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhAnhLaptopRepository extends JpaRepository<HinhAnhLaptop, Integer> {
    List<HinhAnhLaptop> findByLaptop_IdLaptopAndLaHinhChinhFalseOrderByThuTuHienThiAsc(Integer idLaptop);
}
