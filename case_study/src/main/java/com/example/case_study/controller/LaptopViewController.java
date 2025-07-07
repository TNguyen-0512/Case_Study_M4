package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/laptop")
public class LaptopViewController {

    @Autowired
    private ILaptopService laptopService;

    @GetMapping("/view")
    public String list(Model model) {
        Pageable pageable = PageRequest.of(0, 10);
        model.addAttribute("laptops", laptopService.findAll(pageable));
        return "admin/laptop/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("laptop", new Laptop());
        return "admin/laptop/form";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Laptop laptop) {
        laptopService.save(laptop);
        return "redirect:/admin/laptop/view";
    }

    @GetMapping("/view/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Laptop laptop = laptopService.findById(id);
        model.addAttribute("laptop", laptop);
        return "admin/laptop/form";
    }

    @PostMapping("/update/{id}")
    public String saveUpdate(@PathVariable Integer id, @ModelAttribute Laptop laptop) {
        laptop.setIdLaptop(id);
        laptopService.save(laptop);
        return "redirect:/admin/laptop/view";
    }

    @GetMapping("/view/delete/{id}")
    public String delete(@PathVariable Long id) {
        laptopService.delete(id);
        return "redirect:/admin/laptop/view";
    }
}