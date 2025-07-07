package com.example.case_study.controller;

import com.example.case_study.model.NhanVien;
import com.example.case_study.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/nhan-vien")
public class NhanVienViewController {

    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("nhanViens", nhanVienService.findAll());
        return "admin/nhan-vien/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "admin/nhan-vien/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        NhanVien nv = nhanVienService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
        model.addAttribute("nhanVien", nv);
        return "admin/nhan-vien/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.save(nhanVien);
        return "redirect:/admin/nhan-vien/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        nhanVienService.deleteById(id);
        return "redirect:/admin/nhan-vien/view";
    }
}
