package com.example.case_study.controller;

import com.example.case_study.model.VaiTro;
import com.example.case_study.service.IVaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/vai-tro")
public class VaiTroController {

    @Autowired
    private IVaiTroService vaiTroService;

    @GetMapping
    public List<VaiTro> findAll() {
        return vaiTroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VaiTro> findById(@PathVariable Integer id) {
        return vaiTroService.findById(id);
    }

    @PostMapping
    public VaiTro create(@RequestBody VaiTro vaiTro) {
        return vaiTroService.save(vaiTro);
    }

    @PutMapping("/{id}")
    public VaiTro update(@PathVariable Integer id, @RequestBody VaiTro vaiTro) {
        vaiTro.setIdVaiTro(id);
        return vaiTroService.save(vaiTro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        vaiTroService.deleteById(id);
    }
}
