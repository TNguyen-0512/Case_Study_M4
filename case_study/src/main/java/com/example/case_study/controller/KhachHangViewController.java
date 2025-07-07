package com.example.case_study.controller;

import com.example.case_study.model.KhachHang;
import com.example.case_study.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/khach-hang")
public class KhachHangViewController {

    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("khachHangs", khachHangService.findAll());
        return "admin/khach-hang/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "admin/khach-hang/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        KhachHang kh = khachHangService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
        model.addAttribute("khachHang", kh);
        return "admin/khach-hang/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute KhachHang khachHang) {
        khachHangService.save(khachHang);
        return "redirect:/admin/khach-hang/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        khachHangService.deleteById(id);
        return "redirect:/admin/khach-hang/view";
    }
}
