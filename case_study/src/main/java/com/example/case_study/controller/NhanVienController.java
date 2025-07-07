package com.example.case_study.controller;

import com.example.case_study.model.NhanVien;
import com.example.case_study.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {

    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping
    public List<NhanVien> findAll() {
        return nhanVienService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<NhanVien> findById(@PathVariable Integer id) {
        return nhanVienService.findById(id);
    }

    @PostMapping
    public NhanVien create(@RequestBody NhanVien nhanVien) {
        return nhanVienService.save(nhanVien);
    }

    @PutMapping("/{id}")
    public NhanVien update(@PathVariable Integer id, @RequestBody NhanVien nhanVien) {
        nhanVien.setIdNhanVien(id);
        return nhanVienService.save(nhanVien);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        nhanVienService.deleteById(id);
    }
}
