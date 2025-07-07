package com.example.case_study.controller;

import com.example.case_study.model.ChiTietNhapKho;
import com.example.case_study.service.IChiTietNhapKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/chi-tiet-nhap-kho")
public class ChiTietNhapKhoController {

    @Autowired
    private IChiTietNhapKhoService chiTietNhapKhoService;

    @GetMapping
    public List<ChiTietNhapKho> findAll() {
        return chiTietNhapKhoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ChiTietNhapKho> findById(@PathVariable Integer id) {
        return chiTietNhapKhoService.findById(id);
    }

    @PostMapping
    public ChiTietNhapKho create(@RequestBody ChiTietNhapKho chiTietNhapKho) {
        return chiTietNhapKhoService.save(chiTietNhapKho);
    }

    @PutMapping("/{id}")
    public ChiTietNhapKho update(@PathVariable Integer id, @RequestBody ChiTietNhapKho chiTietNhapKho) {
        chiTietNhapKho.setIdChiTietNhap(id);
        return chiTietNhapKhoService.save(chiTietNhapKho);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        chiTietNhapKhoService.deleteById(id);
    }
}
