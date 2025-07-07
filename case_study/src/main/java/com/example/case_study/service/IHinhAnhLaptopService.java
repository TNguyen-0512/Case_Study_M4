package com.example.case_study.service;

import com.example.case_study.model.HinhAnhLaptop;

import java.util.List;

public interface IHinhAnhLaptopService {
    List<HinhAnhLaptop> findHinhPhuByLaptopId(Integer idLaptop);
}
