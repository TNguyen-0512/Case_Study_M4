package com.example.case_study.controller;

import com.example.case_study.model.DanhMuc;
import com.example.case_study.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/danh-muc")
public class DanhMucViewController {

    @Autowired
    private IDanhMucService danhMucService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("danhMucs", danhMucService.findAll());
        return "admin/danh-muc/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("danhMuc", new DanhMuc());
        return "admin/danh-muc/form";
    }

    @PostMapping("/save")
    public String saveCreate(@ModelAttribute DanhMuc danhMuc) {
        danhMucService.save(danhMuc);
        return "redirect:/admin/danh-muc/view";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        DanhMuc danhMuc = danhMucService.findById(id).orElseThrow();
        model.addAttribute("danhMuc", danhMuc);
        return "admin/danh-muc/form";
    }

    @PostMapping("/update/{id}")
    public String saveUpdate(@PathVariable Integer id, @ModelAttribute DanhMuc danhMuc) {
        danhMuc.setIdDanhMuc(id);
        danhMucService.save(danhMuc);
        return "redirect:/admin/danh-muc/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        danhMucService.deleteById(id);
        return "redirect:/admin/danh-muc/view";
    }
}
