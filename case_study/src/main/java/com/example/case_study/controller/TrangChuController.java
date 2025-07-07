package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.LaptopService;
import com.example.case_study.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TrangChuController {

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping({"/", "/product"})
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(required = false) String tenLaptop,
                       @RequestParam(required = false) Integer thuongHieuId) {

        Pageable pageable = PageRequest.of(page, 6);
        Page<Laptop> laptops = laptopService.filterByTenLaptopAndThuongHieu(tenLaptop, thuongHieuId, pageable);

        model.addAttribute("products", laptops);
        model.addAttribute("productCount", laptops.getTotalElements());

        // Giữ lại điều kiện lọc
        model.addAttribute("tenLaptop", tenLaptop);
        model.addAttribute("thuongHieuId", thuongHieuId);

        // Danh sách thương hiệu để render tab
        model.addAttribute("thuongHieus", thuongHieuService.findAll());

        return "product/list";
    }

    @GetMapping("/product/filter")
    public String filterFragment(Model model,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(required = false) String tenLaptop,
                                 @RequestParam(required = false) Integer thuongHieuId) {

        Pageable pageable = PageRequest.of(page, 6);
        Page<Laptop> laptops = laptopService.filterByTenLaptopAndThuongHieu(tenLaptop, thuongHieuId, pageable);

        model.addAttribute("products", laptops);
        return "fragments/product-list :: productList";
    }

    @GetMapping("/product/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Laptop laptop = laptopService.findById(id);
        if (laptop == null) {
            return "error/404";
        }
        model.addAttribute("product", laptop);
        return "product/detail";
    }
}
