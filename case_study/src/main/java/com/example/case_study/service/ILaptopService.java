package com.example.case_study.service;

import com.example.case_study.model.Laptop;

import java.util.List;
import java.util.Optional;

public interface ILaptopService {
    List<Laptop> findAll();
    Optional<Laptop> findById(Integer id);
    Laptop save(Laptop laptop);
    void deleteById(Integer id);
}
