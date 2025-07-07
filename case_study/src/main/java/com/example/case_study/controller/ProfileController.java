package com.example.case_study.controller;

import com.example.case_study.model.KhachHang;
import com.example.case_study.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private KhachHangService khachHangService;

    // Hiển thị trang cá nhân
    @GetMapping
    public String viewProfile(Model model, Principal principal) {
        KhachHang kh = khachHangService.findByUsername(principal.getName());
        model.addAttribute("khachHang", kh);
        return "user/profile";   // <== mapping taới templates/user/profile.html
    }

    // Form chỉnh sửa
    @GetMapping("/edit")
    public String editProfileForm(Model model, Principal principal) {
        KhachHang kh = khachHangService.findByUsername(principal.getName());
        model.addAttribute("khachHang", kh);
        return "user/edit";      // <== mapping tới templates/user/edit.html
    }

    // Xử lý lưu chỉnh sửa
    @PostMapping("/edit")
    public String saveProfile(@ModelAttribute("khachHang") KhachHang formKh,
                              Principal principal,
                              RedirectAttributes ra) {
        KhachHang kh = khachHangService.findByUsername(principal.getName());
        kh.setHoTen(formKh.getHoTen());
        kh.setEmail(formKh.getEmail());
        kh.setSoDienThoai(formKh.getSoDienThoai());
        kh.setDiaChi(formKh.getDiaChi());
        khachHangService.save(kh);

        ra.addFlashAttribute("success", "Cập nhật thông tin thành công!");
        return "redirect:/profile";
    }
}
