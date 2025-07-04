package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.LaptopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model,
                       @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 6, Sort.by(Sort.Direction.ASC, "tenLaptop"));
        Page<Laptop> laptops = laptopService.findAll(pageable);
        long totalItems = laptopService.countAll();
        model.addAttribute("products", laptops.getContent());
        model.addAttribute("productCount", totalItems);
        return "product/list";
    }
}
