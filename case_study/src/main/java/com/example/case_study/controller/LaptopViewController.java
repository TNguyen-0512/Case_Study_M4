package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("laptops", laptopService.findAll());
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

    // Sửa lại đường dẫn để khớp với HTML
    @GetMapping("/view/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        Laptop laptop = laptopService.findById(id).orElseThrow();
        model.addAttribute("laptop", laptop);
        return "admin/laptop/form";
    }

    @PostMapping("/update/{id}")
    public String saveUpdate(@PathVariable Integer id, @ModelAttribute Laptop laptop) {
        laptop.setIdLaptop(id);
        laptopService.save(laptop);
        return "redirect:/admin/laptop/view";
    }

    // Sửa lại đường dẫn để khớp với HTML
    @GetMapping("/view/delete/{id}")
    public String delete(@PathVariable Integer id) {
        laptopService.deleteById(id);
        return "redirect:/admin/laptop/view";
    }
}