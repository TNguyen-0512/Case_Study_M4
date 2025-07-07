package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/laptop")
public class LaptopController {

    @Autowired
    private ILaptopService laptopService;

    @GetMapping
    public Page<Laptop> findAll(Pageable pageable) {
        return laptopService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Laptop findById(@PathVariable Long id) {
        return laptopService.findById(id);
    }

    @PostMapping
    public Laptop create(@RequestBody Laptop laptop) {
        laptopService.save(laptop);
        return laptop;
    }

    @PutMapping("/{id}")
    public Laptop update(@PathVariable Integer id, @RequestBody Laptop laptop) {
        laptop.setIdLaptop(id);
        laptopService.save(laptop);
        return laptop;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        laptopService.delete(id.longValue());
    }
}