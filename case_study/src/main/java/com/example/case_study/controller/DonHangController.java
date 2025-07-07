package com.example.case_study.controller;

import com.example.case_study.model.DonHang;
import com.example.case_study.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/don-hang")
public class DonHangController {

    @Autowired
    private IDonHangService donHangService;

    @GetMapping
    public List<DonHang> findAll() {
        return donHangService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DonHang> findById(@PathVariable Integer id) {
        return donHangService.findById(id);
    }

    @PostMapping
    public DonHang create(@RequestBody DonHang donHang) {
        return donHangService.save(donHang);
    }

    @PutMapping("/{id}")
    public DonHang update(@PathVariable Integer id, @RequestBody DonHang donHang) {
        donHang.setIdDonHang(id);
        return donHangService.save(donHang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        donHangService.deleteById(id);
    }
}
