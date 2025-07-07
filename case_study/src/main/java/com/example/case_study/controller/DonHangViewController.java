package com.example.case_study.controller;

import com.example.case_study.model.DonHang;
import com.example.case_study.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/don-hang")
public class DonHangViewController {

    @Autowired
    private IDonHangService donHangService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("donHangs", donHangService.findAll());
        return "admin/don-hang/list";
    }

    @GetMapping("/chi-tiet/{id}")
    public String chiTiet(@PathVariable Integer id, Model model) {
        DonHang donHang = donHangService.findById(id).orElseThrow();
        model.addAttribute("donHang", donHang);
        return "admin/don-hang/chi-tiet";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        donHangService.deleteById(id);
        return "redirect:/admin/don-hang/view";
    }
}
