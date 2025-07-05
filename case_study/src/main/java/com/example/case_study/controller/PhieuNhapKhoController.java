package com.example.case_study.controller;

import com.example.case_study.model.PhieuNhapKho;
import com.example.case_study.service.IPhieuNhapKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/phieu-nhap-kho")
public class PhieuNhapKhoController {

    @Autowired
    private IPhieuNhapKhoService phieuNhapKhoService;

    @GetMapping
    public List<PhieuNhapKho> findAll() {
        return phieuNhapKhoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PhieuNhapKho> findById(@PathVariable Integer id) {
        return phieuNhapKhoService.findById(id);
    }

    @PostMapping
    public PhieuNhapKho create(@RequestBody PhieuNhapKho phieuNhapKho) {
        return phieuNhapKhoService.save(phieuNhapKho);
    }

    @PutMapping("/{id}")
    public PhieuNhapKho update(@PathVariable Integer id, @RequestBody PhieuNhapKho phieuNhapKho) {
        phieuNhapKho.setIdPhieuNhap(id);
        return phieuNhapKhoService.save(phieuNhapKho);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        phieuNhapKhoService.deleteById(id);
    }
}
