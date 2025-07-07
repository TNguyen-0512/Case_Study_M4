package com.example.case_study.controller;

import com.example.case_study.service.IBaoCaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/bao-cao")
public class BaoCaoController {

    @Autowired
    private IBaoCaoService baoCaoService;

    @GetMapping("/doanh-thu")
    public String doanhThu(Model model) {
        model.addAttribute("tongDoanhThu", baoCaoService.tongDoanhThu());
        model.addAttribute("doanhThuTheoThang", baoCaoService.doanhThuTheoThang());
        model.addAttribute("doanhThuTheoNam", baoCaoService.doanhThuTheoNam());
        return "admin/bao-cao/doanh-thu";
    }
}
