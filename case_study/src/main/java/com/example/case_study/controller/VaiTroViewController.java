package com.example.case_study.controller;

import com.example.case_study.model.VaiTro;
import com.example.case_study.service.IVaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/vai-tro")
public class VaiTroViewController {

    @Autowired
    private IVaiTroService vaiTroService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("vaiTros", vaiTroService.findAll());
        return "admin/vai-tro/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("vaiTro", new VaiTro());
        return "admin/vai-tro/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute VaiTro vaiTro) {
        vaiTroService.save(vaiTro);
        return "redirect:/admin/vai-tro/view";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        VaiTro vaiTro = vaiTroService.findById(id).orElseThrow();
        model.addAttribute("vaiTro", vaiTro);
        return "admin/vai-tro/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute VaiTro vaiTro) {
        vaiTro.setIdVaiTro(id);
        vaiTroService.save(vaiTro);
        return "redirect:/admin/vai-tro/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        vaiTroService.deleteById(id);
        return "redirect:/admin/vai-tro/view";
    }
}
