package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.DonHangService;
import com.example.case_study.service.LaptopService;
import com.example.case_study.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    private DonHangService donHangService;

    @GetMapping({"/", "/product"})
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(required = false) String tenLaptop,
                       @RequestParam(required = false) Integer thuongHieuId,
                       @RequestParam(required = false) BigDecimal giaMin,
                       @RequestParam(required = false) BigDecimal giaMax,
                       @RequestParam(required = false) String cpu,
                       @RequestParam(required = false) String ram,
                       @RequestParam(required = false) String oCung) {

        Pageable pageable = PageRequest.of(page, 6);
        Page<Laptop> laptops = laptopService.filterLaptops(
                tenLaptop, thuongHieuId, giaMin, giaMax, cpu, ram, oCung, pageable
        );

        model.addAttribute("products", laptops);
        model.addAttribute("productCount", laptops.getTotalElements());

        // Giữ lại dữ liệu lọc
        model.addAttribute("tenLaptop", tenLaptop);
        model.addAttribute("thuongHieuId", thuongHieuId);
        model.addAttribute("giaMin", giaMin);
        model.addAttribute("giaMax", giaMax);
        model.addAttribute("cpu", cpu);
        model.addAttribute("ram", ram);
        model.addAttribute("oCung", oCung);

        // Truyền danh sách thương hiệu
        model.addAttribute("thuongHieus", thuongHieuService.findAll());

        return "product/list";
    }

    @GetMapping("/product/filter")
    public String filterFragment(Model model,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(required = false) String tenLaptop,
                                 @RequestParam(required = false) Integer thuongHieuId,
                                 @RequestParam(required = false) BigDecimal giaMin,
                                 @RequestParam(required = false) BigDecimal giaMax,
                                 @RequestParam(required = false) String cpu,
                                 @RequestParam(required = false) String ram,
                                 @RequestParam(required = false) String oCung) {

        Pageable pageable = PageRequest.of(page, 6);
        Page<Laptop> laptops = laptopService.filterLaptops(
                tenLaptop, thuongHieuId, giaMin, giaMax, cpu, ram, oCung, pageable
        );

        model.addAttribute("products", laptops);
        return "fragments/product-list :: productList";
    }

    @GetMapping("/product/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Laptop laptop = laptopService.findById(id);
        if (laptop == null) {
            return "error/404"; // hoặc redirect về home nếu cần
        }
        model.addAttribute("product", laptop); // sử dụng tên "product" để dùng lại HTML hiện tại
        return "product/detail";
    }
}