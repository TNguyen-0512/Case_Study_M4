package com.example.case_study.controller;

import com.example.case_study.model.ThuongHieu;
import com.example.case_study.service.IThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuViewController {

    @Autowired
    private IThuongHieuService thuongHieuService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("thuongHieus", thuongHieuService.findAll());
        return "admin/thuong-hieu/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("thuongHieu", new ThuongHieu());
        return "admin/thuong-hieu/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        ThuongHieu thuongHieu = thuongHieuService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thương hiệu"));
        model.addAttribute("thuongHieu", thuongHieu);
        return "admin/thuong-hieu/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ThuongHieu thuongHieu) {
        thuongHieuService.save(thuongHieu);
        return "redirect:/admin/thuong-hieu/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        thuongHieuService.deleteById(id);
        return "redirect:/admin/thuong-hieu/view";
    }
}
