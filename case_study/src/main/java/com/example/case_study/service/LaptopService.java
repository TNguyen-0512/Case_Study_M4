package com.example.case_study.service;

import com.example.case_study.model.Laptop;
import com.example.case_study.repository.LaptopRepository;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService implements ILaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findById(Integer id) {
        return laptopRepository.findById(id);
    }

    @Override
    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public void deleteById(Integer id) {
        laptopRepository.deleteById(id);
    }
}
