package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/laptop")
public class LaptopController {

    @Autowired
    private ILaptopService laptopService;

    @GetMapping
    public List<Laptop> findAll() {
        return laptopService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Laptop> findById(@PathVariable Integer id) {
        return laptopService.findById(id);
    }

    @PostMapping
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopService.save(laptop);
    }

    @PutMapping("/{id}")
    public Laptop update(@PathVariable Integer id, @RequestBody Laptop laptop) {
        laptop.setIdLaptop(id);
        return laptopService.save(laptop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        laptopService.deleteById(id);
    }
}
