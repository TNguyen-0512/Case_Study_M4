package com.example.case_study.controller;

import com.example.case_study.model.KhachHang;
import com.example.case_study.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping
    public List<KhachHang> findAll() {
        return khachHangService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<KhachHang> findById(@PathVariable Integer id) {
        return khachHangService.findById(id);
    }

    @PostMapping
    public KhachHang create(@RequestBody KhachHang khachHang) {
        return khachHangService.save(khachHang);
    }

    @PutMapping("/{id}")
    public KhachHang update(@PathVariable Integer id, @RequestBody KhachHang khachHang) {
        khachHang.setIdKhachHang(id);
        return khachHangService.save(khachHang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        khachHangService.deleteById(id);
    }
}
