package com.example.case_study.controller;

import com.example.case_study.model.ThuongHieu;
import com.example.case_study.service.IThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuController {

    @Autowired
    private IThuongHieuService thuongHieuService;

    @GetMapping
    public List<ThuongHieu> findAll() {
        return thuongHieuService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ThuongHieu> findById(@PathVariable Integer id) {
        return thuongHieuService.findById(id);
    }

    @PostMapping
    public ThuongHieu create(@RequestBody ThuongHieu thuongHieu) {
        return thuongHieuService.save(thuongHieu);
    }

    @PutMapping("/{id}")
    public ThuongHieu update(@PathVariable Integer id, @RequestBody ThuongHieu thuongHieu) {
        thuongHieu.setIdThuongHieu(id);
        return thuongHieuService.save(thuongHieu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        thuongHieuService.deleteById(id);
    }
}
