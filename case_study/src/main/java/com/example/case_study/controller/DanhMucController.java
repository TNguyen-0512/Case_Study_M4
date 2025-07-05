package com.example.case_study.controller;

import com.example.case_study.model.DanhMuc;
import com.example.case_study.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/danh-muc")
public class DanhMucController {

    @Autowired
    private IDanhMucService danhMucService;

    @GetMapping
    public List<DanhMuc> findAll() {
        return danhMucService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DanhMuc> findById(@PathVariable Integer id) {
        return danhMucService.findById(id);
    }

    @PostMapping
    public DanhMuc create(@RequestBody DanhMuc danhMuc) {
        return danhMucService.save(danhMuc);
    }

    @PutMapping("/{id}")
    public DanhMuc update(@PathVariable Integer id, @RequestBody DanhMuc danhMuc) {
        danhMuc.setIdDanhMuc(id);
        return danhMucService.save(danhMuc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        danhMucService.deleteById(id);
    }
}
