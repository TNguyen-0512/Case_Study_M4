package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private ILaptopService laptopService;

    @GetMapping
    public String listLaptops(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "brand", required = false) String brand,
            Model model) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("idLaptop").descending());
        Page<Laptop> laptopPage;

        if (search != null && !search.isEmpty() && brand != null && !brand.isEmpty()) {
            laptopPage = laptopService.findByTenLaptopAndThuongHieu(search, brand, pageable);
        } else if (search != null && !search.isEmpty()) {
            laptopPage = laptopService.findByTenLaptopContaining(search, pageable);
        } else if (brand != null && !brand.isEmpty()) {
            laptopPage = laptopService.findByThuongHieuTenContaining(brand, pageable);
        } else {
            laptopPage = laptopService.findAll(pageable);
        }

        model.addAttribute("products", laptopPage.getContent());
        model.addAttribute("totalPages", laptopPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);
        model.addAttribute("brand", brand);

        return "all-products";
    }
    @GetMapping("/detail/{id}")
    public String showLaptopDetail(@PathVariable("id") Long id, Model model) {
        Laptop product = laptopService.findById(id);
        if (product == null) {
            return "redirect:/laptop";
        }
        model.addAttribute("product", product);
        model.addAttribute("hinhAnhPhu", product.getHinhAnhPhu()); // Thêm dòng này
        return "laptop-detail";
    }





}
