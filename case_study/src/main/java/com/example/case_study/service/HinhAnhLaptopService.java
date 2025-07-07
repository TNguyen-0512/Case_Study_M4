package com.example.case_study.service;

import com.example.case_study.model.HinhAnhLaptop;
import com.example.case_study.repository.HinhAnhLaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhAnhLaptopService implements IHinhAnhLaptopService {

    @Autowired
    private HinhAnhLaptopRepository hinhAnhLaptopRepository;

    @Override
    public List<HinhAnhLaptop> findHinhPhuByLaptopId(Integer idLaptop) {
        return hinhAnhLaptopRepository.findByLaptop_IdLaptopAndLaHinhChinhFalseOrderByThuTuHienThiAsc(idLaptop);
    }
}
